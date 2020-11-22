package github.veikkoroc.framework.netty.netty.dubborpc.publicinterface;

/**
 *
 *  服务提供方与服务消费方都需要的公共API
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 22:55
 */
public interface HelloService {

    /**
     * say hello
     * @param mes
     * @return
     */
    String hello(String mes);

}
