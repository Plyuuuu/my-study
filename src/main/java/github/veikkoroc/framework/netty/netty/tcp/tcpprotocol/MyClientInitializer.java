package github.veikkoroc.framework.netty.netty.tcp.tcpprotocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 9:51
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 加入自定义编码器
        pipeline.addLast(new MyEncoder());
        // 加入解码器
        pipeline.addLast(new MyDecoder());
        // 加入自定义处理器
        pipeline.addLast(new MyClientHandler());
    }
}
