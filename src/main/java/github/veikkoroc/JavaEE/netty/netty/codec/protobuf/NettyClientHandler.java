package github.veikkoroc.JavaEE.netty.netty.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 11:36
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当通道就绪就会触发该方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("Client ChannelHandlerContext = "+ctx);

        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Server ~", CharsetUtil.UTF_8));

    }

    /**
     * 当通道可以读取时触发该方法
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("Server reply :"+buf.toString(CharsetUtil.UTF_8));
        System.out.println("Server address is "+ctx.channel().remoteAddress());
    }

    /**
     * 发生异常就关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
