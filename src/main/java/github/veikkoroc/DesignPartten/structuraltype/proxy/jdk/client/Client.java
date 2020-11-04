package github.veikkoroc.DesignPartten.structuraltype.proxy.jdk.client;

import github.veikkoroc.DesignPartten.structuraltype.proxy.jdk.api.UserDao;
import github.veikkoroc.DesignPartten.structuraltype.proxy.jdk.handler.DaoLogHandler;
import github.veikkoroc.DesignPartten.structuraltype.proxy.jdk.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:40
 */
public class Client {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();
        InvocationHandler handler = new DaoLogHandler(userDao);
        UserDao proxy = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(),new Class[]{UserDao.class},handler);
        proxy.findUserById("迪丽热巴");
        proxy.findUserById(1);
    }
}
