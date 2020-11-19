package github.veikkoroc.Framework.netty.netty.http;



import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/12 22:38
 */
public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        // 向管道加入处理器

        // 得到管道
        ChannelPipeline pipeline = channel.pipeline();

        // 1、加入一个Netty提供的HttpServerCodec
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());

        // 2、加入自定义的Handler
        pipeline.addLast("MyHttpServerHandler",new HttpServerHandler());

        System.out.println("这里下断点~");


    }
}
