package github.veikkoroc.container.collection;

import java.util.Vector;

/**
 *  Vector（实现类，JDK1.0出现）
 *      1.介绍：作为 List 接口的古老实现类；线程安全，效率低；底层使用 Object[]存储；
 *      底层创建长度为10的Object[];扩容为原来的2倍；
 *      2.类似 ArrayList 的所有方法加了 synchronized
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/23 20:40
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
    }
}
