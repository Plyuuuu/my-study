package github.veikkoroc.framework.netty.netty.dubborpc.customer;

import github.veikkoroc.framework.netty.netty.dubborpc.netty.NettyClient;
import github.veikkoroc.framework.netty.netty.dubborpc.publicinterface.HelloService;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 0:39
 */
public class ClientBootStrap {

    /**
     * 定义协议头
     */
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {

        // 创建一个消费者
        NettyClient customer = new NettyClient();

        System.out.println("getBean before ");
        // 创建代理对象
        HelloService helloService = (HelloService) customer.getBean(HelloService.class, providerName);
        System.out.println("getBean after");


        System.out.println(" 开始调用方法... ");

        // 通过代理对象调用服务提供者的方法（服务）
        String hello = helloService.hello("你好Dubbo~");

        System.out.println("远程调用的结果 : "+hello);

    }
}
