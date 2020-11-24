package github.veikkoroc.framework.netty.netty.dubborpc3.server;

import github.veikkoroc.framework.netty.netty.dubborpc3.api.SayHello;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 17:26
 */
public class SayHelloImpl implements SayHello {
    @Override
    public String sayHello(String s) {
        System.out.println(" SayHelloImpl 的 sayHello 方法被调用 ，传入的参数是 : "+s);
        return "Hello~";
    }
}
