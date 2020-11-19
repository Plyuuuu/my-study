package github.veikkoroc.Framework.spring.c_AOP;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 被增强的类
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 14:06
 */
@Service(value = "user")
@Component
public class User {
    public void add(){
        System.out.println("Add...");
    }
}
