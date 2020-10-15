package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第5节让线程休眠的sleep方法;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 11:28
 */
public class SleepStudy2 {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("Child thread is in sleep!");

                    Thread.sleep(5000);

                    System.out.println("Child thread is in awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // 启动线程
        thread.start();

        // 主线程休眠2s
        Thread.sleep(2000);

        // 主线程中断子线程
        thread.interrupt();
    }
}
