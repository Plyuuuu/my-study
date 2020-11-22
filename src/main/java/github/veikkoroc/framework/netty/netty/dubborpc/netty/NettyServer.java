package github.veikkoroc.framework.netty.netty.dubborpc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 23:13
 */
public class NettyServer {


    /**
     *   编写一个方法，完成对NettyServer的初始化和启动的任务
     */
    public static void startServer(String hostName,int port){
     startServer0(hostName, port);
    }


    private static void startServer0(String hostName,int port){

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup,workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();

                                pipeline.addLast(new StringDecoder());
                                pipeline.addLast(new StringEncoder());
                                // 自己的业务处理器
                                pipeline.addLast(new NettyServerHandler());
                            }
                        });

            ChannelFuture channelFuture = serverBootstrap.bind(hostName, port).sync();


            System.out.println("服务端 IP :"+hostName +" PORT : "+port);
            System.out.println("服务提供者开始提供服务...");


            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
