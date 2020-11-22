package github.veikkoroc.designpartten.structuraltype.proxy.jdk4;



/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 14:03
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        Object bean = proxyFactory.getBean();
        Hello hello = (Hello)bean;
        hello.hello("迪丽热巴");
    }
}
