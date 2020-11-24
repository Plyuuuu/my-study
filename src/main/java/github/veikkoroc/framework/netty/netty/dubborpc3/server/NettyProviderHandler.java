package github.veikkoroc.framework.netty.netty.dubborpc3.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 17:30
 */
public class NettyProviderHandler extends ChannelInboundHandlerAdapter {
    /**
     *  客户端发送数据到这里接收
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("服务端收到消息: "+msg);

        System.out.println("正在调用方法...");
        // 调用方法
        SayHelloImpl sayHello = new SayHelloImpl();
        String res = sayHello.sayHello(msg.toString());

        System.out.println("方法调用结果:"+res);
        System.out.println("正在返回调用结果...");

        // 把调用结果返回给客户端
        ctx.writeAndFlush(res);
        System.out.println("调用结果返回成功.");
    }

    /**
     * 发送异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("服务器端发送异常: "+cause.getMessage());
        ctx.close();
    }
}
