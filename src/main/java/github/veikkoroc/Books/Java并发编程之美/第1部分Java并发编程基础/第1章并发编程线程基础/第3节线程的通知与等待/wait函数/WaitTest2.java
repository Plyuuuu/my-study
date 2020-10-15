package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第3节线程的通知与等待.wait函数;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 23:47
 */
public class WaitTest2 {
    /**
     * 创建资源
     *
     */
    private static volatile Object resource1 = new Object();
    private static volatile Object resource2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 获取resource1共享资源的监视器锁
                    synchronized (resource1){
                        System.out.println("thread1 get resource1 lock");

                        // 获取resource2共享资源监视器
                        synchronized (resource2){
                            System.out.println("thread1 get resource2 lock");

                            // 线程1阻塞，并且释放获取得到的resource1的锁
                            System.out.println("thread1 release resource1 lock");
                            resource1.wait();

                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // 创建线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 休眠 1 s
                    Thread.sleep(1000);

                    // 获取resource1共享资源的监视器锁
                    synchronized (resource1){
                        System.out.println("thread2 get resource1 lock");
                        System.out.println("thread2 try get resource2 lock...");

                        // 获取resource2共享资源的同步监视器
                        synchronized (resource2){
                            System.out.println("thread2 get resource2 lock");

                            // 线程2阻塞，并释放获取到的resource1的锁
                            System.out.println("thread2 release resource1 lock");
                            resource1.wait();

                        }
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待两个线程结束
        thread1.join();
        thread2.join();

        System.out.println("Main over...");

    }

}
