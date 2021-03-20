package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.依赖注入;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest{

    @Autowired
    private Beauty beauty;

    @org.junit.Test
    public void test01(){
        beauty.eat();
    }

}
