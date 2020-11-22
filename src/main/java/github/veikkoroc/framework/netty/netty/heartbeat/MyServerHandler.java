package github.veikkoroc.framework.netty.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/16 17:23
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx 上下文
     * @param evt 事件
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            // 向下转型
            IdleStateEvent event = (IdleStateEvent)evt;

            String eventType = null;

            switch (event.state()){
                case ALL_IDLE:
                    eventType = "服务器读写空闲";break;
                case READER_IDLE:
                    eventType = "服务器读空闲";break;
                case WRITER_IDLE:
                    eventType = "服务器写空闲";break;
            }

            System.out.println(ctx.channel().remoteAddress()+"---超时事件---"+eventType);
            System.out.println("服务器做相应处理...");

            // 如果发生空闲我们关闭通道,只会发生一次心跳检测
            ctx.channel().close();
        }

    }
}
