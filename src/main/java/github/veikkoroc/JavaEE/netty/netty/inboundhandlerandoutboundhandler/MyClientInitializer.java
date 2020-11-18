package github.veikkoroc.JavaEE.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:16
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        // 加入出站的handler，对数据进行编码
        pipeline.addLast(new MyLongToByteEncoder());
        // 入站解码handler
        pipeline.addLast(new MyByteToLongDecoder2());

        // 加入自定义的Handler处理业务逻辑
        pipeline.addLast(new MyClientHandler());


    }


}
