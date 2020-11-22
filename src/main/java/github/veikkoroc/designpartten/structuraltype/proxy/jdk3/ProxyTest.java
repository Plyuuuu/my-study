package github.veikkoroc.designpartten.structuraltype.proxy.jdk3;

import java.lang.reflect.Proxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 15:31
 */
public class ProxyTest {
    public static void main(String[] args) {

        // 创建一个InvocationHandler对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        // 使用 myInvocationHandler 生成代理对象
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);
        person.walk();
        person.sayHello("迪丽热巴");

    }
}
