package github.veikkoroc.concurrent.creatthread;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/18 22:28
 */
public class ThreadPoolTest {
    /**
     * 核心线程数
     */
    private  static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程数
     */
    private  static final int MAX_POOL_SIZE = 10;
    /**
     * 等待的任务队列容量
     */
    private  static final int QUEUE_CAPACITY = 100;
    /**
     * 核心线程外的线程推迟销毁的时间
     */
    private  static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //使用阿里巴巴推荐线程池创建方式
        //通过ThreadPoolExecutor构造函数自定义参数创建

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象，（WorkerThread类实现了Runnable接口）
            MyRunnable worker = new MyRunnable("" + i);
            //执行Runnable
            threadPoolExecutor.execute(worker);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){

        }
        System.out.println("完成所有线程...");
    }




}
class MyRunnable implements Runnable{
    private String command;
    public MyRunnable(String s){
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start.time = "+new Date());

        System.out.println(Thread.currentThread().getName()+"start.time = "+new Date());
    }
    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}