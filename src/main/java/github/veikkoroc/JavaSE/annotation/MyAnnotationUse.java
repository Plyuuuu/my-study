package github.veikkoroc.JavaSE.annotation;

/**
 * 获取注解内信息:
 *  1、获取被注解修饰的类的.Class对象
 *  2、获取该对象的某个注解
 *  3、获取注解内的值
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 9:40
 */
@MyAnnotation(value = "VeikkoRoc",level = "15",type = 8)
public class MyAnnotationUse {
    public static void main(String[] args) {
        Class<MyAnnotationUse> myAnnotationUseClass = MyAnnotationUse.class;
        MyAnnotation annotation = myAnnotationUseClass.getAnnotation(MyAnnotation.class);
        int type = annotation.type();
        String value = annotation.value();
        String level = annotation.level();
        System.out.println("type:"+type);
        System.out.println("value:"+value);
        System.out.println("level:"+level);
    }
}
