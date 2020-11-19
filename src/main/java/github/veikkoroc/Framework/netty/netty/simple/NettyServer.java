package github.veikkoroc.Framework.netty.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 10:41
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 创建两个事件循环组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1); // 设置BossGroup只有一个线程（或叫做NIOEventLoop）
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            // 创建服务端启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 使用链式编程配置服务端参数
            serverBootstrap.group(bossGroup,workerGroup) // 设置两个线程组
                    .channel(NioServerSocketChannel.class) // 设置服务端通道实现
                    .option(ChannelOption.SO_BACKLOG,128) // 设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)// 设置保持连接的状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 创建一个通道测试对象
                        // 给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    });// 给我们的workerGroup的NioEventLoop对应的pipeline设置处理器

            // 绑定端口且同步，生成一个channelFuture对象
            ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();


//            Server is ready...
//            添加Future的Listener成功~
//            监听 8888 端口成功~
            System.out.println("Server is ready...");

            // 异步执行
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Thread.sleep(1000);
                    if (channelFuture.isSuccess()){
                        System.out.println("监听 8888 端口成功~");
                    }else {
                        System.out.println("监听 8888 端口失败！");
                    }
                }
            });

            System.out.println("添加Future的Listener成功~");


            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();

        }finally {
            // 发生异常要优雅的关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}
