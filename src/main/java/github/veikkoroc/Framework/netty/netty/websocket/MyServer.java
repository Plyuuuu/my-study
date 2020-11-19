package github.veikkoroc.Framework.netty.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/16 17:44
 */
public class MyServer {
    public static void main(String[] args) {

        // 创建两个线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)) // 在BossGroup添加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //  获取pipeline
                            ChannelPipeline pipeline = channel.pipeline();

                            //因为基于http协议，使用http的编码解码器
                             pipeline.addLast(new HttpServerCodec());
                            // 是以块写的，添加ChunkedWriteHandler处理器
                            pipeline.addLast(new ChunkedWriteHandler());

                            /*
                                说明:
                                    1、http数据在传输过程中是分段的,HttpObjectAggregator 就可以将多个端聚合
                                    2、这就是为什么，浏览器发送大量数据时，就会发出多次http请求
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /*
                                说明:
                                    1、对于WebSocket,它的数据是以帧(frame)的形式传递
                                    2、可以看到WebSocketFrame 下面有6个子类
                                    3、浏览器请求时，ws://localhost:9000/hello 表示请求的uri
                                    4、WebSocketServerProtocolHandler 核心功能是将Http协议升级为websocket协议，保持长连接

                                    5、是通过一个状态码101，把http协议升级到ws协议
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));


                            // 自定义的Handler,处理业务逻辑,经过了pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));处理会交给
                            // 这个处理器处理
                            pipeline.addLast(new MyTextWebSocketFrameHandler());

                        }
                    });


            // 绑定端口，异步处理
            ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();

            System.out.println("Server is ready....");

            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
