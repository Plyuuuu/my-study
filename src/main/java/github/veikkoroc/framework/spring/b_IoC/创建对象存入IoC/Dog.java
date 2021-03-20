package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/16 17:28
 */
@Component
public class Dog {

    @Value(value = "Jack")
    private String name;

    public Dog(){

    }
    public Dog(String name){
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
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
