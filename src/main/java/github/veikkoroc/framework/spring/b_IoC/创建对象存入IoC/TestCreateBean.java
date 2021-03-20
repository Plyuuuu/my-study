package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC;

import github.veikkoroc.framework.spring.b_IoC.SpringConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/16 17:44
 */
public class TestCreateBean {


    @Autowired
    private Cat cat;

    @Autowired
    private Dog dog;

    @Test
    public void test01(){
        // null
        System.out.println(cat);
    }
    @Test
    public void test03(){
        // null
        System.out.println(dog);
    }



    @Test
    public void test02(){

        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(cat);

    }

    @Test
    public void test04(){

        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

    }
}
