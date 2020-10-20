package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第9节Unsafe类;

import sun.misc.Unsafe;

/**
 *
 *  无法实例化Unsafe类，因为不是BootStrap加载器加载的UnsafeDemo
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 11:24
 */
public class UnsafeDemo {

    // 获取Unsafe的实例 1
    static final Unsafe unsafe = Unsafe.getUnsafe();

    // 记录变量state在类UnsafeDemo中的偏移值 2
    static final long stateOffset;

    // 变量3
    private volatile long state = 0;

    static {
        try{
            // 获取state变量在类UnsafeDemo中的偏移值 4
            stateOffset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {

        // 创建实例，并且设置state值为1
        UnsafeDemo demo = new UnsafeDemo();
        System.out.println("before:"+demo.state);

        boolean success = unsafe.compareAndSwapInt(demo, stateOffset, 0, 1);
        System.out.println(success);

        System.out.println("after:"+demo.state);

    }

}
