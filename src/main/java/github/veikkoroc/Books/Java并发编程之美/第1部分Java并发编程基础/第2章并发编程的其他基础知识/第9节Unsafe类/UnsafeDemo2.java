package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第9节Unsafe类;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 13:24
 */
public class UnsafeDemo2 {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {

            // 使用反射获取Unsafe的成员变量theUnsafe
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");

            // 设置为可存取
            theUnsafe.setAccessible(true);

            // 获取该变量的值
            unsafe = (Unsafe)theUnsafe.get(null);

            // 获取state在UnsafeDemo中的偏移量
            stateOffset = unsafe.objectFieldOffset(UnsafeDemo2.class.getDeclaredField("state"));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeDemo2 unsafeDemo2 = new UnsafeDemo2();
        System.out.println("before:"+unsafeDemo2.state);
        boolean b = unsafe.compareAndSwapInt(unsafeDemo2, stateOffset, 0, 1);
        System.out.println(b);
        System.out.println("after:"+unsafeDemo2.state);
    }

}
