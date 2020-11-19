package github.veikkoroc.Framework.spring.c_AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * User的增强类
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 14:07
 */
@Component
@Aspect
public class UserProxy {
    /**
     * 前置通知
     */
    @Before(value = "execution(* github.veikkoroc.Framework.spring.c_AOP.User.add(..))")
    public void before(){
        System.out.println("Before...");
    }

}
