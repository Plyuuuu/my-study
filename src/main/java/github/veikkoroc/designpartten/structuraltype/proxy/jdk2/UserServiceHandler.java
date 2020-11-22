package github.veikkoroc.designpartten.structuraltype.proxy.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 13:48
 */
public class UserServiceHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    public UserServiceHandler(Object o){
        this.target = o;
    }


    /**
     * 调用目标方法，执行功能增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前");
        Object result = method.invoke(target, args);
        System.out.println("代理之后");
        return result;
    }

}
