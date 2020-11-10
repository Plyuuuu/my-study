package github.veikkoroc.OS.ProducerAndConsumer;

import java.util.Random;

/**
 *
 *
 * 生产者：
 *      1、生产产品
 *      2、往仓库放产品
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 10:43
 */
public class Producer extends Thread{

    Random random = new Random();

    public Producer(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true) {


            // 1、生产产品
            // Math.random()返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
            int product = (int) ((Math.random() + 1)* 1000); // 1000~2000随机数



            // 把产品放入仓库
            System.out.println("\t\t\t\t\t"+Thread.currentThread().getName() + "生产了产品:" + product);
            Warehouse.put(product);




            // 睡一下，防止生产的太快
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
