package github.veikkoroc.Framework.netty.netty.tcp.tcpprotocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 10:08
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 加入自定义的解码器
        pipeline.addLast(new MyDecoder());
        // 加入自定义编码器
        pipeline.addLast(new MyEncoder());
        // 加入自定义Handler
        pipeline.addLast(new MyServerHandler());

    }
}
