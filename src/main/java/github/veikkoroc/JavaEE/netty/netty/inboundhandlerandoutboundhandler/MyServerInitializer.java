package github.veikkoroc.JavaEE.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:02
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        // 入站的handler进行解码 MyByteToLongDecoder
        pipeline.addLast(new MyByteToLongDecoder2());

        pipeline.addLast(new MyLongToByteEncoder());
        // 自定义的handler处理业务逻辑
        pipeline.addLast(new MyServerHandler());
    }

}
