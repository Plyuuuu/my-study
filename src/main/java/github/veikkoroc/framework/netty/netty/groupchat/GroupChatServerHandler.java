package github.veikkoroc.framework.netty.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/14 11:38
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 定义一个channel组，管理所有的channel
     *  GlobalEventExecutor.INSTANCE : 全局的事件处理器,是一个单例
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 一旦与客户端建立连接，第一个被执行
     *      将当前Channel加入到channelGroup
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        // 将该客户加入聊天推送给其他客户端,
        // 该方法会把把channelGroup中所有的channel遍历发送消息
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"加入聊天\n");

        channelGroup.add(channel);

        // 当前群聊人数
        System.out.println("当前群聊人数:"+channelGroup.size());

    }

    /**
     * 表示断开连接，退出群聊
     *  将xx客户离开推送给当前在线的客户
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        // 当前方法自动移除channelGroup中的channel，不需要手动删除
        // channelGroup.remove(channel);

        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"退出群聊\n");

        // 当前群聊人数
        System.out.println("当前群聊人数:"+channelGroup.size());
    }

    /**
     *  表示channel处于活动的状态，提示xxx上线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.err.println(ctx.channel().remoteAddress()+"上线了~");

    }

    /**
     * 表示channel处于非活跃状态，提示xxx离线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println(ctx.channel().remoteAddress()+"离线了~");
    }


    /**
     * 读取数据
     *
     * @param channelHandlerContext
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

        // 获取当前的channel
        Channel channel = channelHandlerContext.channel();

        // 这时我们遍历channelGroup，根据不同的情况回送不同的消息
        channelGroup.forEach(ch -> {
            // 不是当前的channel,直接转发消息
            if (ch != channel){
                ch.writeAndFlush("[客户]"+channel.remoteAddress()+" 发送消息:"+s+"\n");
            }else {
                // 回显自己发送的消息
                ch.writeAndFlush("[自己]发送了:"+s+"\n");
            }
        });

    }

    /**
     * 发生异常直接关闭该通道
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
