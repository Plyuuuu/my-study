package github.veikkoroc.designpartten.structuraltype.proxy.jdk4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 13:59
 */
public class ProxyFactory {
    public Object getBean(){
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{Hello.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke");
                System.out.println(args[0]);
                return null;
            }
        });
    }
}
