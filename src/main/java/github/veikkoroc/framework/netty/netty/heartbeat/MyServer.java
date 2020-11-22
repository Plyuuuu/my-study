package github.veikkoroc.framework.netty.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/16 0:20
 */
public class MyServer {
    public static void main(String[] args) {

        // 创建两个线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)) // 在BossGroup添加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //  获取pipeline
                            ChannelPipeline pipeline = channel.pipeline();

                            // 添加一个netty提供的IdleStateHandler,用来处理空闲状态的处理器
                            // readerIdleTime: 表示服务器多长时间没有读了,就会发送一个心跳检测包,检测是否还是连接的状态
                            // writerIdleTime: 表示服务器多长时间没有写了,就会发送一个心跳检测包,检测是否还是连接的状态
                            // allIdleTime: 表示服务器既没有读,也没有写了,就会发送一个心跳检测包,检测是否还是连接的状态

                            // 当IdleStateEvent(闲置状态事件)触发后,就会传递给管道的下一个handler去处理,通过调用下一个handler的userEventTiggered
                            // 方法,在该方法中处理IdleStateEvent(读空闲,写空闲,读写空闲)
                            pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));

                            // 加入一个对空闲检测进一步处理的handler(自定义)
                            pipeline.addLast(new MyServerHandler());

                        }
                    });


            // 绑定端口，异步处理
            ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();

            System.out.println("Server is ready....");

            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
