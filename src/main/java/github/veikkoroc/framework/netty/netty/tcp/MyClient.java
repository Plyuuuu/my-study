package github.veikkoroc.framework.netty.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:13
 */
public class MyClient {

    public static void main(String[] args) {

        NioEventLoopGroup group = new NioEventLoopGroup();
        try{

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer()); // 自定义一个初始化类

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            group.shutdownGracefully();
        }
    }

}
