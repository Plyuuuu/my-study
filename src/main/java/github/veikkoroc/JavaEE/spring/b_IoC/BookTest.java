package github.veikkoroc.JavaEE.spring.b_IoC;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 12:36
 */
public class BookTest {
    /**
     * Set 注入属性
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring/b.xml");
        Book book = ioc.getBean("book", Book.class);
        System.out.println(book.toString());
    }
    /**
     * p 名称空间注入属性
     * 基于Set
     */
    @Test
    public void test01(){
        Book book2 = new ClassPathXmlApplicationContext("spring/b.xml").getBean("book2", Book.class);
        System.out.println(book2.toString());
    }

    /**
     * 存在两个类循环依赖
     */
    @Test
    public void test02(){
        Book book_has_person = new ClassPathXmlApplicationContext("spring/b.xml").getBean("book_has_person", Book.class);
        System.out.println(book_has_person.toString());
    }
}
