package github.veikkoroc.Framework.netty.netty.tcp.tcpprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 11:00
 */
public class MyEncoder extends MessageToByteEncoder<MessageProtocol> {


    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {

        System.out.println("MessageProtocol的编码器被调用");

        // 把 Message的长度和和内容发出去
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());

    }


}
