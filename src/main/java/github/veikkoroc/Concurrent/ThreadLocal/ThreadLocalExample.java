package github.veikkoroc.Concurrent.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/13 23:28
 */
public class ThreadLocalExample implements Runnable{


    /**
     * ArrayList不是线程安全的
     *
     *  private static ArrayList<Integer> list = new ArrayList<>();
     *
     * ()->new ArrayList()  ===> ArrayList::new
     */



    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(SimpleDateFormat::new);



    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(threadLocalExample,"->" +i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

    }


    @Override
    public void run() {
        System.out.println("Thread name="+Thread.currentThread().getName()+" default Formatter=" +dateFormatThreadLocal.get().toPattern());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dateFormatThreadLocal.set(new SimpleDateFormat());

        System.out.println("Thread name="+Thread.currentThread().getName()+" Formatter=" +dateFormatThreadLocal.get().toPattern());
    }
}

