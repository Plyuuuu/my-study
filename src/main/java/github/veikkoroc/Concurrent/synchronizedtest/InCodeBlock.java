package github.veikkoroc.Concurrent.synchronizedtest;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 16:48
 */
public class InCodeBlock {
    public static void test(){
        synchronized (InCodeBlock.class){
            System.out.println("synchronized 作用在代码块上~"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
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
