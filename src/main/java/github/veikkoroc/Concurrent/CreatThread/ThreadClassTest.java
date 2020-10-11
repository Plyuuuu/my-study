package github.veikkoroc.Concurrent.CreatThread;

/**
 * 继承Thread类，重写run方法
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/18 21:14
 */
public class ThreadClassTest extends Thread{
    @Override
    public void run() {
        System.out.println("我是一个线程");
    }

    public static void main(String[] args) {
        //创建线程
        ThreadClassTest threadClassTest = new ThreadClassTest();
        //启动线程
        threadClassTest.start();
    }
}
