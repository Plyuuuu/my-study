package github.veikkoroc.JavaEE.spring.c_AOP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 14:15
 */
public class AOPTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/c.xml");
        User user = ioc.getBean("user", User.class);
        user.add();
    }
}
