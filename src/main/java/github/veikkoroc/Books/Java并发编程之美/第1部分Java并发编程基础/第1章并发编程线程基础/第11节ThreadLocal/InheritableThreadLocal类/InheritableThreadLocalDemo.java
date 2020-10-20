package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第11节ThreadLocal.InheritableThreadLocal类;

/**
 *
 * ThreadLocal ：子线程不共享父线程的 ThreadLocal 的值
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/17 23:38
 */
public class InheritableThreadLocalDemo {

    // 1.创建线程变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        // 设置线程变量
        threadLocal.set("hello world");

        // 启动子线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                // 子线程输出线程变量的值
                System.out.println("thread:"+threadLocal.get());

            }
        }).start();

        // 主线程输出线程变量的值
        System.out.println("main:"+threadLocal.get());


    }
}
