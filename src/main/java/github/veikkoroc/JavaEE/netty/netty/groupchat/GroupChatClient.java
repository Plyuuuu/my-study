package github.veikkoroc.JavaEE.netty.netty.groupchat;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/14 14:45
 */
public class GroupChatClient {

    private final String HOST = "127.0.0.1";
    private final int PORT = 9000;

    public void run(){

        //  创建一个NioEventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建且配置客户端引导类
            Bootstrap bootstrap = new Bootstrap().group(group)
                                                .channel(NioSocketChannel.class)
                                                .handler(new ChannelInitializer<SocketChannel>() {
                                                    @Override
                                                    protected void initChannel(SocketChannel channel) throws Exception {

                                                        // 得到pipeline
                                                        ChannelPipeline pipeline = channel.pipeline();
                                                        // 加入相关的handler
                                                        pipeline.addLast("decoder",new StringDecoder());
                                                        pipeline.addLast("encoder",new StringEncoder());
                                                        pipeline.addLast(new GroupChatClientHandler());

                                                    }
                                                });
            ChannelFuture channelFuture = bootstrap.connect(HOST, PORT).sync();
            // 得到channel
            Channel channel = channelFuture.channel();
            System.out.println("----------------"+channel.localAddress()+"---------------");

            // 客户端需要输入消息，创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                // 通过channel发送出去
                channel.writeAndFlush(s+"\r\n");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }


    }

    public static void main(String[] args) {
        GroupChatClient groupChatClient = new GroupChatClient();
        groupChatClient.run();
    }
}
