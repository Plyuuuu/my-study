package github.veikkoroc.framework.netty.netty.dubborpc.netty;

import github.veikkoroc.framework.netty.netty.dubborpc.customer.ClientBootStrap;
import github.veikkoroc.framework.netty.netty.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务器的Handler比较简单
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 23:24
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 获取客户端发送的消息，并调用我们的服务
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("收到客户端写入的数据~~~");
        System.out.println("msg = "+msg);
        // 客户端在调用服务器服务时，我们需要定义一个协议
        // 比如:我们要求每次发消息时都必须以某个字符串开头 "HelloService#hello#"
        if (msg.toString().startsWith(ClientBootStrap.providerName)){
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));

            ctx.writeAndFlush(result);
        }



    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
