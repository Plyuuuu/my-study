package github.veikkoroc.designpartten.structuraltype.proxy.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 12:33
 */
public class Client {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 1.创建目标对象
        UserServiceImpl userService = new UserServiceImpl();

        // 2.创建InvocationHandler对象
        UserServiceHandler userServiceHandler = new UserServiceHandler(userService);

        // 3.创建代理对象
        Object o = Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), userServiceHandler);

        UserService userService1 = (UserService)o;

        userService1.findUserById(2);

    }
}
