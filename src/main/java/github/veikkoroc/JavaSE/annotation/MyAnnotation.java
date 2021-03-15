package github.veikkoroc.JavaSE.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265102803921888
 *自定义注解：
 * 1、使用 @interface
 * 2、添加参数，默认值
 * 3、使用元注解
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 9:02
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    int type() default 0;

    String level() default "info";

    String value() default "";
}
