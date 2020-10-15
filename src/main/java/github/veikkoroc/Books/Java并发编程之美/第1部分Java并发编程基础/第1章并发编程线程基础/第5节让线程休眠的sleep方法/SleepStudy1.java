package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第5节让线程休眠的sleep方法;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  线程在睡眠时拥有的监视器资源不会被释放
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 11:11
 */
public class SleepStudy1 {

    // 创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                // 获取独占锁
                lock.lock();
                System.out.println("线程A获取Lock");

                try {
                    System.out.println("child threadA is in sleep!");

                    Thread.sleep(1000);

                    System.out.println("child threadA is in awake!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    System.out.println("线程A立即释放Lock");
                    lock.unlock();

                }


            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                // 获取独占锁
                lock.lock();
                System.out.println("线程B获得Lock");
                try {
                    System.out.println("child threadB is in sleep!");

                    Thread.sleep(1000);

                    System.out.println("child threadB is in awake!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    System.out.println("线程B立即释放Lock");
                    lock.unlock();

                }

            }
        });

        // 启动线程
        threadA.start();
        threadB.start();


    }


}
