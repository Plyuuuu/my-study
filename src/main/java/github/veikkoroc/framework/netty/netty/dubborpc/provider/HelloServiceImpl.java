package github.veikkoroc.framework.netty.netty.dubborpc.provider;

import github.veikkoroc.framework.netty.netty.dubborpc.publicinterface.HelloService;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 22:58
 */
public class HelloServiceImpl implements HelloService {
    /**
     * 当有消费方调用该方法时就返回一个结果
     * @param mes
     * @return
     */
    @Override
    public String hello(String mes) {
        System.out.println("收到客户端消息="+mes);
        // 根据mes返回不同结果
        if (mes != null){
            return "你好客户端，我已经收到消息["+mes+"]";
        }else {
            return "你好客户端，我已经收到消息";
        }
    }
}
