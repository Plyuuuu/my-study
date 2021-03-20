package github.veikkoroc.framework.spring.b_IoC.创建对象存入IoC.注解Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/20 11:39
 */
@Component(value = "littleBoy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boy {
    @Value("蔡徐坤")
    private String name;
}
