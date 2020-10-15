package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第4节等待线程终止的join方法;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 10:53
 */
public class JoinStudy2 {
    public static void main(String[] args) {

        // 线程One
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("ThreadOne Begin Run！ ");
                for (;;){}
            }
        });

        // 获取主线程
        final Thread mainThread = Thread.currentThread();

        // 现场Tow
        Thread threadTow = new Thread(new Runnable() {
            @Override
            public void run() {
                // 睡一秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 中断主线程
                mainThread.interrupt();
            }
        });

        // 启动子线程1
        threadOne.start();

        // 启动子线程2（延迟一秒中断主线程）
        threadTow.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("mainThread : "+e);
        }


    }
}
