package github.veikkoroc.Concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 16:54
 */
public class ExecutorsDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Object> in_callable_ = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                System.out.println("In Callable ");
                Thread.sleep(1000);
                return "Out";
            }
        });

        Object o = in_callable_.get();
        System.out.println(o);
        executorService.shutdown();
    }
}
