package github.veikkoroc.JavaEE.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 15:54
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("MyByteToLongDecoder2 被调用");

        // 在 ReplayingDecoder 不需要判断数据是否足够被读取，内部会进行处理

        out.add(in.readLong());

    }
}
