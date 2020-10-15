package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第6节让出CPU执行权的yield方法;

/**
 *
 *  yield:让
 *
 * 让出CPU执行权
 *
 * API：
 *  static void yield()
 *           暂停当前正在执行的线程对象，并执行其他线程。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/15 11:34
 */
public class YieldDemo1 implements Runnable {

    YieldDemo1(){
        // 创建并启动线程
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new YieldDemo1();
        new YieldDemo1();
        //new YieldDemo1();
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            // 当 i 为偶数时让出CPU执行权，放弃时间片，进行下一轮调度
            if (i/2 == 0){
                System.out.println(Thread.currentThread() + "yield cpu..."+i);
                Thread.yield();
            }else {

                System.out.println(Thread.currentThread()+"get cpu..."+i);
            }
        }
        System.out.println(Thread.currentThread() + "is over!");

    }

}
