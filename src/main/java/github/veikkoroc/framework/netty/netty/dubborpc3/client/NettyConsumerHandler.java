package github.veikkoroc.framework.netty.netty.dubborpc3.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 17:43
 */
public class NettyConsumerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush("hello server~");

    }

    /**
     * 服务器端往通道写数据触发该方法
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("服务器端返回调用结果: "+msg);


    }
}
