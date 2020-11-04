package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第8节Java中的CAS操作;

import sun.misc.Unsafe;

/**
 *
 *
    public final native boolean compareAndSwapObject(Object var1, long var2, Object var4, Object var5);

    public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);

    public final native boolean compareAndSwapLong(Object var1, long var2, long var4, long var6);

 
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/29 19:30
 */
public class CASTest {
    public static void main(String[] args) {
        Unsafe unsafe =Unsafe.getUnsafe();
    }
}
