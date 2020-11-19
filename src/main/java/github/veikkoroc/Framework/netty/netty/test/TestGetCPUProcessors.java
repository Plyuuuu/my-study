package github.veikkoroc.Framework.netty.netty.test;

import io.netty.util.NettyRuntime;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 11:57
 */
public class TestGetCPUProcessors {
    public static void main(String[] args) {
        System.out.println("My CPU Processors is "+ NettyRuntime.availableProcessors());
    }
}
