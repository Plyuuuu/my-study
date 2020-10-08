package github.veikkoroc.design_partten.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/22 14:19
 */
public class PersonCGLIBTest {
    @Test
    public void testCGLIB(){
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、声明代理哪个类 Enhancer.setSuperclass用来设置父类型
        enhancer.setSuperclass(Person.class);
        //3、设置回滚 FixedValue用来对所有拦截的方法返回相同的值
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "CGLIB";
            }
        });
        //Enhancer.create(Object…)方法是用来创建增强对象的
        Person proxy = (Person)enhancer.create();
        System.out.println(proxy.study(null));
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
        for (;;){
            
        }

    }


}
