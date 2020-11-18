package github.veikkoroc.JavaEE.netty.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 14:22
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {

        System.out.println("服务器："+channelHandlerContext.channel().remoteAddress()+"   收到服务器消息:"+aLong);

    }

    /**
     * 建立连接就会发送数据
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");
        // 发送一个Long
         ctx.writeAndFlush(123456L);


        // 分析: 十六个字节的字符串
        // 该处理器的前一个handler是MyLongToByteEncoder，其父类是MessageToByteEncoder
        // 父类中的write方法如果传入的数据是它应该编码的它就会去编码，否则就直接写出去
        // 因此：我们在编写Encoder 要注意传入的数据类型和处理的数据类型要一致
        // ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcd", CharsetUtil.UTF_8));

    }
}
