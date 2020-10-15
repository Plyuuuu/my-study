package github.veikkoroc.Concurrent.CreatThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/18 21:27
 */
public class FutureTaskTest implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.println("睡前~");

        Thread.sleep(1000);

        // 证明异步
        System.out.println("睡后~");

        return "我是一个线程:"+ Thread.currentThread().getName();
    }

    public static void main(String[] args) {

        //创建Callable接口实现类对象
        FutureTaskTest futureTaskTest = new FutureTaskTest();

        //创建FutureTask(异步任务)，传入Callable接口实现类对象
        FutureTask<String> futureTask = new FutureTask<>(futureTaskTest);

        //启动线程
        new Thread(futureTask).start();
        //new Thread(futureTask).start();


        try {
            //等待任务执行完毕，获得返回结果
            String res = "res:"+futureTask.get();

            //测试异步，等到call方法执行完毕才执行
            System.out.println("测试异步~~~");

            System.out.println(res);




            //获取不到第二个线程？？？
            //String res1 = futureTask.get();
            //System.out.println(res1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
