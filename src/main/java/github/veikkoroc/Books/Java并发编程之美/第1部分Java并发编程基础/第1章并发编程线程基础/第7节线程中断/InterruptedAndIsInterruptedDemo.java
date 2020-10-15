package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第7节线程中断;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 23:59
 */
public class InterruptedAndIsInterruptedDemo {
    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){}
            }
        });

        // 启动线程
        threadOne.start();

        // 获取中断标志
        System.out.println("获取中断标志 isInterrupted:"+threadOne.isInterrupted());

        // 设置中断标志
        threadOne.interrupt();

        // 获取中断标志
        System.out.println("获取中断标志 isInterrupted:"+threadOne.isInterrupted());

        // 获取中断标志并重置 --->
        System.out.println("获取中断标志并重置 interrupted:"+Thread.interrupted());

        // 获取中断标志
        System.out.println("获取中断标志 isInterrupted:"+threadOne.isInterrupted());

    }
}
