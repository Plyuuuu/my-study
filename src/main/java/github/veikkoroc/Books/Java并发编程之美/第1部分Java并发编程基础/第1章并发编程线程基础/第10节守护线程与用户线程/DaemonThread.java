package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第10节守护线程与用户线程;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/17 18:41
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I`am a daemon thread.");
            }
        });

        // 设置线程为守护线程
        thread.setDaemon(true);

        thread.start();

        Thread.currentThread().sleep(1000);

    }
}
