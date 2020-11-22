package github.veikkoroc.Concurrent.synchronizedtest;

import org.junit.Test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 16:57
 */
public class InCodeBlock2WithoutStatic {

    public void test(){
        synchronized (InCodeBlock2WithoutStatic.class){
            System.out.println("synchronized 作用在代码块上~"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Test
    public void myStart(){
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        one.start();
        two.start();
    }

}
