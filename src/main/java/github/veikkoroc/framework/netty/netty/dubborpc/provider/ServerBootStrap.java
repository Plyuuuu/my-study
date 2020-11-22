package github.veikkoroc.framework.netty.netty.dubborpc.provider;

import github.veikkoroc.framework.netty.netty.dubborpc.netty.NettyServer;

/**
 *
 * ServerBootStrap 会启动一个服务提供者，就是NettyServer
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 23:10
 */
public class ServerBootStrap {
    public static void main(String[] args) {
        // 代码代填...
        NettyServer.startServer("127.0.0.1",7000);
    }
}
