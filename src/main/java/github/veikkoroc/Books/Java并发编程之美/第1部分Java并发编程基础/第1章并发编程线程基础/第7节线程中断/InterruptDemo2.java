package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第7节线程中断;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 23:46
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("threadOne begin sleep 200 S");
                    Thread.sleep(200000);
                    System.out.println("threadOne awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("threadOne leaving normally");

            }
        });

        // 启动线程
        threadOne.start();

        // 确保子线程进入休眠
        Thread.sleep(1000);

        // 打断子线程的休眠，让子线程从sleep函数返回
        threadOne.interrupt();

        // 等待子线程执行完毕
        threadOne.join();

        System.out.println("main thread is over~");
    }
}
