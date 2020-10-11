package github.veikkoroc.Concurrent.CreatThread;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/18 21:21
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("我是一个线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程:"+Thread.currentThread().getName());
        //创建线程、启动线程
        RunnableTest runnableTest = new RunnableTest();

        new Thread(runnableTest).start();
        new Thread(runnableTest).start();
    }
}
