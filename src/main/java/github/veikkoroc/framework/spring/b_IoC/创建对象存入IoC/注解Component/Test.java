package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.注解Component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 11:40
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        Boy boy = ioc.getBean("littleBoy", Boy.class);
        System.out.println(boy);
    }
}
