package github.veikkoroc.JavaEE.netty.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 *
 * 有数据交互: 继承SimpleChannelInboundHandler
 *
 *
 *      TextWebSocketFrame:表示文本帧
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/16 18:07
 */
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {



    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

        System.out.println("服务器端收到消息:"+textWebSocketFrame.text());

        // 回复消息
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("服务器时间:"+ LocalDateTime.now()+"  "+textWebSocketFrame.text()));


    }

    /**
     * 一旦客户端连接服务器，就会调用这个方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // id:表示唯一值,        LongText 是唯一的
        System.out.println("HandlerAdder 被调用"+ctx.channel().id().asLongText());
        //  ShortText是不唯一的
        System.out.println("HandlerAdder 被调用"+ctx.channel().id().asShortText());
    }

    /**
     * 客户端与服务器断开连接就会调用此方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("HandlerRemoved 被调用"+ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("发生异常:"+cause.getMessage());
        ctx.close();
    }
}
