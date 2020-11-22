package github.veikkoroc.framework.netty.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 23:43
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    /**
     * 上下文
     *
     */
    private ChannelHandlerContext context;
    /**
     * 调用方法返回的结果
     */
    private String result;
    /**
     * 调用方法的参数
     */
    private String para;

    /**
     * 与服务器创建连接就会被调用   [1]
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("客户端 NettyClientHandler 的 channelActive 被调用了~");
        // 因为在其他方法需要用到 ctx
        context = ctx;

    }

    /**
     * 收到服务器的数据后就会调用        [4]
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public synchronized void  channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        // 唤醒等待的线程
        notifyAll();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 被代理对象调用，发送数据给服务器，-> wait -> 等待唤醒(channelRead) ->返回结果     [3]     [5]
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {

        System.out.println("call 执行了。。");

        System.out.println("写 pare ："+para+"到服务器");
        System.out.println("ctx :"+context);
        context.writeAndFlush(para);
        System.out.println("客户端context.writeandflush执行完成。。。");
        // 进行wait,等待channelRead 方法获取到服务器结果后，唤醒
        wait();
        // 服务方返回结果
        return result;

    }

    /**
     * 设置传入的参数          [2]
     * @param para
     */
    void setPara(String para){
        this.para = para;
        System.out.println("设置 this.para : "+this.para);
    }
}
