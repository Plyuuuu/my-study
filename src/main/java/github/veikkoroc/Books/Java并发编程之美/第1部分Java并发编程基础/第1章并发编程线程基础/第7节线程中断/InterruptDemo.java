package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第7节线程中断;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 12:17
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted()){

                    System.out.println(Thread.currentThread()+" hello ");

                }
            }
        });

        // 启动子线程
        thread.start();

        // 主线程休眠1s，以便中断前让子线程输出
        Thread.sleep(100);

        // 中断子线程
        System.out.println("Main thread interrupt thread");
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();
        System.out.println("Main is over");
        

    }
}
