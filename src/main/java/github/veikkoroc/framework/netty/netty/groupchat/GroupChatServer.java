package github.veikkoroc.framework.netty.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/14 10:59
 */
public class GroupChatServer {

    /**
     * 服务器监听的端口
     */
    private final int PORT = 9000;

    // 编写run方法，处理客户端请求
    public void run()  {

        // 创建两个线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            // 创建服务端启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 配置服务端启动对象
            serverBootstrap.group(bossGroup,workerGroup)
                            .channel(NioServerSocketChannel.class) // 服务端通道的实现
                            .option(ChannelOption.SO_BACKLOG,128) // 设置线程队列得到连接的个数，BossGroup的到连接的个数(backlog:积压的工作)
                            .childOption(ChannelOption.SO_KEEPALIVE,true) // 与workerGroup保持连接的状态
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel channel) throws Exception {

                                    // 获取到pipeline
                                    ChannelPipeline pipeline = channel.pipeline();

                                    // 向管道加入解码器
                                    pipeline.addLast("decoder",new StringDecoder());

                                    // 加入编码器
                                    pipeline.addLast("encoder",new StringEncoder());

                                    // 加入自己的业务处理handler
                                    pipeline.addLast(new GroupChatServerHandler());

                                }

                            });

            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();

            System.out.println("Netty Server is running...");

            // 监听关闭事件
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.run();
    }


}
