package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第4节等待线程终止的join方法;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 10:33
 */
public class JoinStudy {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Child threadA over!");
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Child threadB over");
            }
        });

        // 启动子线程
        threadA.start();
        threadB.start();

        System.out.println("Wait all child thread over!");

        // 等待子线程执行完毕
        threadA.join();
        threadB.join();

        System.out.println("All child thread over!");

    }
}
