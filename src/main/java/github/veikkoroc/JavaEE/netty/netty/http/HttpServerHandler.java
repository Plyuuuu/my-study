package github.veikkoroc.JavaEE.netty.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 *
 *  1、SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter
 *  2、HttpObject ：客户端和服务器端相互通讯的数据被封装成 HttpObject
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/12 22:37
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    /**
     * 读取客户端数据
     *
     * @param channelHandlerContext
     * @param httpObject
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        // 判断httpObject是不是httpRequest请求
        if (httpObject instanceof HttpRequest){

            // 过滤掉图标的请求
            HttpRequest httpRequest = (HttpRequest) httpObject;
            // 获取URI
            String uri = httpRequest.uri();
            URI uri1 = new URI(uri);
            if ("/favicon.ico".equals(uri1.getPath())){
                System.out.println("/favicon 做出请求,不做响应~");
                return;
            }



            System.out.println("httpObject 类型是: "+httpObject.getClass());
            System.out.println("客户端地址是: "+channelHandlerContext.channel().remoteAddress());

            // 回复信息给浏览器[Http协议]
            ByteBuf content = Unpooled.copiedBuffer("Hello 我是服务器 !", CharsetUtil.UTF_8);

            // 构造一个http响应,httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            // 设置response的相关信息
            //response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"application/json");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            // 将构建好的response返回
            channelHandlerContext.writeAndFlush(response);

        }
    }
}
