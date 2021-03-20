package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.注解Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 11:07
 */
public class Test {

    /*// @Resource
    @Autowired
    private  Girl girl;

    @org.junit.Test
    public void  test1(){
        // null
        System.out.println(girl);
    }*/

    @org.junit.Test
    public void test2(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        Girl girl = ioc.getBean("setInIoC", Girl.class);
        System.out.println(girl);
    }

}
