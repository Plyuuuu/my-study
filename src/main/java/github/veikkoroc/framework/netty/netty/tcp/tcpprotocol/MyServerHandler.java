package github.veikkoroc.framework.netty.netty.tcp.tcpprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 10:09
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        // 接收到数据并且处理
        int length = msg.getLength();
        byte[] content = msg.getContent();
        System.out.println("服务器端接收数据如下");
        System.out.println("length : "+length+"    content : "+new String(content,CharsetUtil.UTF_8));

        System.out.println("服务器接收数据包数量: "+(++this.count));

        // 回复消息
        String string = UUID.randomUUID().toString();
        int responseLength = string.getBytes("UTF-8").length;
        byte[] responseContent = string.getBytes("UTF-8");
        // 构建协议包
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLength(responseLength);
        messageProtocol.setContent(responseContent);

        ctx.writeAndFlush(messageProtocol);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
