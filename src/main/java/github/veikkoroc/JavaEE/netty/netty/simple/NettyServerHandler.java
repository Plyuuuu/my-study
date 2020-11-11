package github.veikkoroc.JavaEE.netty.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 *
 * 说明：
 *      我们自定义Handler需要继承Netty制定好的ChannelInboundHandlerAdapter适配器，
 *      这样的Handler才能称之为Handler
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 10:59
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {



    /**
     * 读取数据事件：读取客户端发送的数据
     *
     * @param ctx 上下文对象，含有 管道pipeline，通道channel，地址
     * @param msg 就是客户端发送的数据，默认是Object
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //===================================普通任务，直接处理=========================================
//        System.out.println("Server ChannelHandlerContext ="+ctx);
//
//        // 将msg转成一个ByteBuf（Netty提供的高性能buffer，不是NIO的ByteBuffer）
//        ByteBuf byteBuf = (ByteBuf) msg;
//        System.out.println("Client send message is :"+byteBuf.toString(CharsetUtil.UTF_8));
//
//        System.out.println("Client address :"+ctx.channel().remoteAddress());



        //===================================耗时的任务，不做处理是只能阻塞，影响后面的程序执行=========================================
//        System.out.println("读取客户端写到Channel的数据...");
//        Thread.sleep(10*1000);
//        ctx.writeAndFlush(Unpooled.copiedBuffer("10s later... Hello Client...",CharsetUtil.UTF_8));
//        System.out.println("Go on....");


        //===============================解决方案1：用户程序自定义的普通任务(把任务提交到NioEventLoop的TaskQueue中)============================
//        ctx.channel().eventLoop().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10*1000);
//                    ctx.writeAndFlush(Unpooled.copiedBuffer("10s later... Hello Client...",CharsetUtil.UTF_8));
//                }catch (Exception e){
//                    System.out.println("channelRead 发送异常 ："+e.getMessage());
//                }
//            }
//        });

        //===============================解决方案2：用户自定义定时任务(把任务提交到scheduleTaskQueue中)==========================
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("10s later... Hello Client...",CharsetUtil.UTF_8));
                }catch (Exception e){
                    System.out.println("channelRead 发送异常 ："+e.getMessage());
                }
            }
        },5, TimeUnit.SECONDS);







    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        System.out.println("客户端写的数据读取完毕...");

        // 把数据写入到缓冲，且刷新到通道，一般会对发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Client~",CharsetUtil.UTF_8));

    }

    /**
     * 发送异常需要进行关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         ctx.channel().close();
    }
}
