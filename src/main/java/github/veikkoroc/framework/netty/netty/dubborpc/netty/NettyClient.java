package github.veikkoroc.framework.netty.netty.dubborpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 0:12
 */
public class NettyClient {

    /**
     * 创建一个线程池
      */
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static NettyClientHandler clientHandler;


    /**
     * 使用代理模式获取代理对象
     * @param serviceClass
     * @param providerName
     * @return
     */
    public Object getBean(Class serviceClass,String providerName){

        return Proxy.newProxyInstance(NettyClient.class.getClassLoader(),
                new Class[]{serviceClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("invoke");
                        System.out.println(args[0]);
                        if (clientHandler == null){
                             System.out.println("initClient...");
                             initClient();
                        }
                        // 设置要发给服务器端的消息
                        // providerName协议头，args[0]客户端调用api传入的参数
                        clientHandler.setPara(providerName+args[0]);


                        return executor.submit(clientHandler).get();
                    }
                }

//                (proxy, method, args) -> {
//                    if (clientHandler == null){
//                        System.out.println("initClient...");
//                        initClient(); }
//
//
//            System.out.println("getBean clientHandler");
//            System.out.println(providerName); // HelloService#hello#
//            System.out.println(args); // null
//
//
//
//            // 设置要发给服务器端的消息
//            // providerName协议头，args[0]客户端调用api传入的参数
//            clientHandler.setPara(providerName+args[0]);
//            return executor.submit(clientHandler).get();
//        }

        );
    }



    /**
     *  初始化客户端
      */
    private static void initClient(){
        clientHandler = new NettyClientHandler();

        // 创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();

        try{
            // 创建bootStrap
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(clientHandler);
                        }
                    });
            // ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7000).sync();
            bootstrap.connect("127.0.0.1", 7000).sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }


    }
}
