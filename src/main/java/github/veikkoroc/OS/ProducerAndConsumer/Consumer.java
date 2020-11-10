package github.veikkoroc.OS.ProducerAndConsumer;

/**
 *
 * 消费者:
 *      1、从仓库获取产品
 *      2、消费产品
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 10:43
 */
public class Consumer extends Thread{

    public Consumer(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true){



            // 从仓库得到产品



            // 获取产品
            int product = Warehouse.get();
            System.err.println("\t\t\t\t\t"+Thread.currentThread().getName()+"获取了产品:"+product);
            // 消费产品





            // 睡一下，防止消费太快
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
