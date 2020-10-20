package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第7节线程中断;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/17 15:50
 */
public class InterruptDemo3 {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                // 中断标志为true时退出循环，并且清除中断标志
                while (!Thread.currentThread().isInterrupted()){

                }
                System.out.println("threadOne isInterrupt:"+Thread.currentThread().isInterrupted());
            }
        });

        // 启动线程
        threadOne.start();

        // 主线程睡1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 设置中断标志
        threadOne.interrupt();

        threadOne.join();

        System.out.println("main is over");

    }
}
