package github.veikkoroc.framework.netty.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/12 22:36
 */
public class HttpServer {
    /**
     * 服务端的端口：8889
     */
    private static final int PORT = 8889;

    public static void main(String[] args) {

        // 创建两个事件循环线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();// 默认使用CPU 核数（8）


        try {
            // 创建服务端启动程序
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 配置服务端启动程序
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) // 服务端通道实现
                    .childHandler(new HttpServerChannelInitializer());

            // 绑定端口 8889
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();

            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()){
                        System.out.println("服务器绑定端口 :"+PORT+" 成功!!!");
                    }   else {
                        System.out.println("服务器绑定端口 :"+PORT+" 失败~~~");
                    }
                }
            });

            System.out.println("服务器已经就绪~~~");

            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }

    }
}
