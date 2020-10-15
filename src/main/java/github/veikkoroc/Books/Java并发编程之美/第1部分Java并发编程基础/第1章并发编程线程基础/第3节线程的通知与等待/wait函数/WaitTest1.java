package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第3节线程的通知与等待.wait函数;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 1.Wait 方法是 Object 类中的方法
 *
 * 2.当一个线程调用一个共享变量的 wait() 方法时，该调用线程会被阻塞挂起。
 *
 * 3.线程会被阻塞挂起后下面几件事情之一才会返回
 *      3.1、其他线调用了改共享对象的 notify() 或者 notifyAll() 方法
 *      3.2、其他线程调用了改线程的 interrupt() 方法，该线程抛出 InterruptException 异常返回。
 *
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 17:40
 */
public class WaitTest1 {

    /**
      共享变量
     */
    String str = "123";

    public static void main(String[] args) {

    }


    @Test
    public void test1(){

        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建实现Callable的对象
     */
    MyThread myThread = new MyThread();
    /**
     * 创建 FutureTask 对象
     */
    FutureTask futureTask = new FutureTask(myThread);

    class MyThread implements Callable {

        @Override
        public Object call() throws Exception {
            str.wait();
            return null;
        }
    }
}
