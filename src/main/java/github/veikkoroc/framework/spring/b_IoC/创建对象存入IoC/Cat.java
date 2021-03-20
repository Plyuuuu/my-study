package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC;

import org.springframework.context.annotation.Bean;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/16 17:34
 */
public class Cat {
    private String name;

    public Cat(){

    }

    public Cat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

//    /**
//     * 无效：@Bean 使用在配置类中
//     * @return
//     */
//    @Bean
//    public static Cat cat(){
//        return new Cat("Tom");
//    }

}
