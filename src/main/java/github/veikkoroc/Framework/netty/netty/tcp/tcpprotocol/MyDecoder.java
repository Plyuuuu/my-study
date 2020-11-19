package github.veikkoroc.Framework.netty.netty.tcp.tcpprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 11:34
 */
public class MyDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("解码器 MyDecoder 被调用");
        // 将得到的二进制字节码->MessageProtocol 数据包
        int length = in.readInt();
        byte[] content = new byte[length];

        in.readBytes(content);

        // 封装成message对象，放入out，传给下一个Handler进行业务处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLength(length);
        messageProtocol.setContent(content);

        out.add(messageProtocol);

    }
}
