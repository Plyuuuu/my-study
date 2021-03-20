package github.veikkoroc.framework.spring.b_IoC;

import github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/16 17:25
 */
@Configuration
@ComponentScan(basePackages = {"github.veikkoroc.framework.spring"})
public class SpringConfig {

    @Bean
    public static Cat cat(){
        return new Cat("Tom");
    }

}
