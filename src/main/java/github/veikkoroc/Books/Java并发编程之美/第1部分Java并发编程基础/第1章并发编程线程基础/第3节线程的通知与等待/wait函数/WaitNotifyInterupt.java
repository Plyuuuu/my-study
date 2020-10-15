package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第3节线程的通知与等待.wait函数;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 0:25
 */
public class WaitNotifyInterupt {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("---begin---");
                    // 阻塞当前线程
                    synchronized (object){
                        object.wait();
                    }
                    System.out.println("---end---");
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });

        thread1.start();

        Thread.sleep(1000);

        System.out.println("开始打断线程1");
        thread1.interrupt();
        System.out.println("结束打断线程1");
    }
}
