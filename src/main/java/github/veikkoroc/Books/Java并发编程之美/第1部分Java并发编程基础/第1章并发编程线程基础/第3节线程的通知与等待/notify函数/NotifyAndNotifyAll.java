package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第3节线程的通知与等待.notify函数;

/**
 *
 * Object的方法
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 10:07
 */
public class NotifyAndNotifyAll {

    /**
     * 创建共享资源
     */
    private static volatile  Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程1
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                //  获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("ThreadA get ResourceA lock");
                    try{
                        System.out.println("ThreadA begin wait...");

                        resourceA.wait();

                        System.out.println("ThreadA end wait...");

                    }catch (Exception e){

                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建线程2
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("ThreadB get ResourceA lock");

                    try{
                        System.out.println("ThreadB begin wait...");

                        resourceA.wait();

                        System.out.println("ThreadB end wait...");

                    }catch (Exception e){

                        e.printStackTrace();
                    }

                }

            }
        });

        // 创建线程3
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (resourceA){

                    // 好像似乎是唤醒先被挂起的线程

                    System.out.println("threadC begin notify");
                    // resourceA.notify();

                    resourceA.notifyAll();
                }

            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(1000);

        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("Main over");
    }
}
