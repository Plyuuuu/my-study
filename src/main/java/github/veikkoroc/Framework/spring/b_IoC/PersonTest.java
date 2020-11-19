package github.veikkoroc.Framework.spring.b_IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 12:39
 */
public class PersonTest {
    /**
     * 构造函数注入
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/b.xml");
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person.toString());
    }


}
