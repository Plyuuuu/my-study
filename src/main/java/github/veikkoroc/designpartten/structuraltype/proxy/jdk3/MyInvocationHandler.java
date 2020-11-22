package github.veikkoroc.designpartten.structuraltype.proxy.jdk3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 15:27
 */
public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("正在执行 InvocationHandler 的 invoke 方法...");
        if (args == null){
            System.out.println("调用该方法没有实参");
        }else {
            System.out.println("调用方法传入的实参为 : "+args[0]);
        }


        return null;
    }
}
