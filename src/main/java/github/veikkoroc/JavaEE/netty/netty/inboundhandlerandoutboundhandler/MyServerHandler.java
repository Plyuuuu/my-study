package github.veikkoroc.JavaEE.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:10
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("从客户端："+channelHandlerContext.channel().remoteAddress()+"读取到long："+aLong);

        // 给客户端发送一个Long
        channelHandlerContext.writeAndFlush(98765L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
