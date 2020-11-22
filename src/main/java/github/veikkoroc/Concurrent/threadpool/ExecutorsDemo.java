package github.veikkoroc.Concurrent.threadpool;

import java.util.concurrent.*;

/**
 * java.util.concurrent.Executor
 *     |--ExecutorService       子接口: public interface ExecutorService extends Executor
 *          |--ThreadPoolExecutor       实现类 : public class ThreadPoolExecutor extends AbstractExecutorService,
 *                                              public abstract class AbstractExecutorService implements ExecutorService
 *          |--ScheduledExecutorService     孙子接口：public interface ScheduledExecutorService extends ExecutorService
 *              |--ScheduledThreadPoolExecutor 实现类：public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService
 *
 *
 *  Executors:
 *      newFixedThreadPool():创建固定大小的线程池
 *      newCachedThreadPool():缓存线程池，线程池的数量不固定，可以根据需求自动更改数量
 *      newSingleThreadExecutor():创建当个线程的线程池
 *      newScheduleThreadPool():创建固定大小的线程池,可以延时或定时执行任务
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 17:48
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
//        Executor executor;
//        ExecutorService executorService;
//        ThreadPoolExecutor threadPoolExecutor;
//        ScheduledExecutorService scheduledExecutorService;
//        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

        // 1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);


        // 2.为线程池中的线程分配任务
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        }); // Runnable


//        pool.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                System.out.println("Hello Callable");
//                return null;
//            }
//        }); // Runnable 或者 Callable

        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


        // 3.关闭线程池
        pool.shutdown();

    }


}
