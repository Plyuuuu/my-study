package github.veikkoroc.Framework.spring.a_helloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 12:27
 */
public class UserTest {
    public static void main(String[] args) {
        //加载spring配置文件
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/a.xml");
        //获取配置文件的对象
        User user = ioc.getBean("user", User.class);
        user.add();
    }
}
