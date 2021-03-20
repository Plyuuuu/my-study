package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.注解Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 10:55
 */
@Configuration
@ComponentScan(basePackages = {"github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.注解Bean"})
public class SpringConfig {

    @Bean
    public Girl setInIoC(){
        return new Girl("迪丽热巴");
    }

}
