package github.veikkoroc.JavaEE.netty.nio.NIODemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/4 15:59
 */
public class IteratorTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.size());

        Iterator<Integer> iterator = set.iterator();

        // 从底层集合中删除此迭代器返回的最后一个元素（可选操作）。
        iterator.next();

        iterator.remove();

        System.out.println(set.size());
    }
}
