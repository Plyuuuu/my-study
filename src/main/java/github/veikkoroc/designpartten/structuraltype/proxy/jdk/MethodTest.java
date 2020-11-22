package github.veikkoroc.designpartten.structuraltype.proxy.jdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 14:29
 */
public class MethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 要被执行方法的对象
        UserServiceImpl userService = new UserServiceImpl();

        // 获取UserServiceImpl运行时对象
        // 使用对象获取Class √
        // Class<UserServiceImpl> clazz = (Class<UserServiceImpl>) userService.getClass();
        // 使用实现类获取Class √
        // Class<UserServiceImpl> clazz = UserServiceImpl.class;
        // 使用接口获取Class √
        Class<UserService> clazz = UserService.class;

        // 获取方法对象 参数1：方法名 参数2：参数类型
        Method method = clazz.getMethod("getUser", int.class);

        // 调用对象userService的getUser方法    参数1：要执行哪个对象的方法 参数2：方法执行时的参数
        Object invoke = method.invoke(userService, 1);
        System.out.println(invoke);
    }
}
