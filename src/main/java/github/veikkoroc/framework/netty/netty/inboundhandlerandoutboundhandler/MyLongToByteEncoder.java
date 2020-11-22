package github.veikkoroc.framework.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:19
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    /**
     * 编码的方法
     *
     * @param channelHandlerContext
     * @param aLong
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long aLong, ByteBuf byteBuf) throws Exception {

        System.out.println("MyLongToByteEncoder encode 被调用");
        System.out.println("aLong="+aLong);
        byteBuf.writeLong(aLong);
    }


}
