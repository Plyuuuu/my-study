package github.veikkoroc.framework.netty.netty.dubborpc3.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 17:43
 */
public class NettyConsumer {
    public static void main(String[] args) {

        // 创建事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new NettyConsumerHandler());
                        }
                    });

            System.out.println("客户端正在连接服务器...");
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9090).sync();
            System.out.println("客户端连接 127.0.0.1 9090 成功...");
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            System.out.println("NettyConsumer 发送异常 :"+e.getMessage());
        }finally {

            group.shutdownGracefully();
        }


    }
}
