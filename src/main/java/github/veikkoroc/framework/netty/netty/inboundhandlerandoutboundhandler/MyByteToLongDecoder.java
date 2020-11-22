package github.veikkoroc.framework.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:05
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /**
     *  decode 方法会根据接收到的数据被调用多次，直到确定没有新的元素添加到List，或者是ByteBuf没有更多的可读字节为止
     * 如果 List list 不为空，就会将list的内容传递给下一个channelinboundHandler处理，该处理的方法也会被调用多次
     * @param channelHandlerContext 上下文
     * @param byteBuf 入站的 ByteBuf
     * @param list List，将解码后的数据传给下一个handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        // 因为 long 8个字节,需要8个字节才能读取一个Long
        if (byteBuf.readableBytes() >= 8){
            list.add(byteBuf.readLong());
        }


    }
}
