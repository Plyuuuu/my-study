package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.依赖注入;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 11:59
 */
//@Component
//@Service
//@Controller
@Repository(value = "beauty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beauty {
    @Value("古力娜扎")
    private String name;
    public void eat(){
        System.out.println(this.name+"Beauty eat.....");
    }
}
