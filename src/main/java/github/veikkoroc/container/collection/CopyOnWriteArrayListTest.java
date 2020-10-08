package github.veikkoroc.container.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * CopyOnWriteArrayList:CopyOnWriteArrayList这是一个ArrayList的线程安全的变体，其原理大概可以通俗的理解为:初始化的时候只有一个容器，
 * 很常一段时间，这个容器数据、数量等没有发生变化的时候，大家(多个线程)，都是读取(假设这段时间里只发生读取的操作)同一个容器中的数据，所以这
 * 样大家读到的数据都是唯一、一致、安全的，但是后来有人往里面增加了一个数据，这个时候CopyOnWriteArrayList 底层实现添加的原理是先copy出一
 * 个容器(可以简称副本)，再往新的容器里添加这个新的数据，最后把新的容器的引用地址赋值给了之前那个旧的的容器地址，但是在添加这个数据的期间，其
 * 他线程如果要去读取数据，仍然是读取到旧的容器里的数据。
 *
 *  总结：读写分开，读不加锁，写加锁
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/23 20:46
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    }
}
