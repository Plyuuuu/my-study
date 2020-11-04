package github.veikkoroc.DesignPartten.structuraltype.proxy.jdk.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 该类定义如何增强
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:26
 */
public class DaoLogHandler implements InvocationHandler {

    private Calendar calendar;
    private Object object;

    public DaoLogHandler(){}

    /**
     * 注入一个需要代理的真实主题对象
     *
     * @param o
     */
    public DaoLogHandler(Object o){
        this.object = o;
    }

    /**
     * 实现 invoke 方法，调用在真实主题中的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        //转发调用
        Object result = method.invoke(object, args);

        System.out.println("调用结束 ~");

        return result;
    }

    private void beforeInvoke(){
        calendar = new GregorianCalendar();
        System.out.println("调用时间 :"+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
    }
}
