package github.veikkoroc.framework.spring.b_IoC.circulardependency;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 13:28
 */
public class ABTest {
    /**
     * 循环依赖Set注入没有报错
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/b.xml");
        A a = ioc.getBean("a", A.class);
        System.out.println(a);
    }

    /**
     * 构造方法注入
     * 会报错：
     *  因为Bean的生命周期第一步就是通过构造器实例化对象，实例化后把Bean对象放入一个Map中，并且提供这个对象的设置属性的方法。
     *  构造器注入的话，依赖了其他类，其他类也是构造器注入且依赖的当前类，那么他们就都无法实例化对象了。
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/b.xml");
        A a1 = ioc.getBean("a1", A.class);
        System.out.println(a1);
    }
}
