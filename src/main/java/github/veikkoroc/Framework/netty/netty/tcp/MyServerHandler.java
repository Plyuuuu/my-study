package github.veikkoroc.Framework.netty.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 10:09
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        // 把客户端读取的字节数组存起来
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);

        // 将字节数组转成字符串
        String message = new String(bytes, CharsetUtil.UTF_8);

        System.out.println("服务器端接收到数据："+message);
        System.out.println("服务器端接收到消息量="+(++this.count));

        // 服务器随机回送数据给客户端
        ByteBuf byteBuf = Unpooled.copiedBuffer(UUID.randomUUID().toString(), CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
