package github.veikkoroc.designpartten.structuraltype.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/22 14:03
 */
public class SampleClass {
    public void test(){
        System.out.println("Hello World");
    }
    public void eat(){
        System.out.println("Eating...");
    }

    public static void main(String[] args) {
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置哪个类要被代理
        enhancer.setSuperclass(SampleClass.class);
        //3、设置如何增强
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Before method run...");
                Object res = methodProxy.invokeSuper(o, objects);
                System.out.println("After method run...");
                return res;
            }
        });

        Object o = enhancer.create();
        SampleClass sampleClass = (SampleClass) o;
        sampleClass.test();
        sampleClass.eat();
    }
}
