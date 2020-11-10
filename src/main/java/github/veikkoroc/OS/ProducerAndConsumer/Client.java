package github.veikkoroc.OS.ProducerAndConsumer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 10:45
 */
public class Client {
    public static void main(String[] args) {
        Consumer consumer1 = new Consumer("消费者A");
        Consumer consumer2 = new Consumer("消费者B");
        Consumer consumer3 = new Consumer("消费者C");

        Producer producer1 = new Producer("生产者A");
        Producer producer2 = new Producer("生产者B");
        Producer producer3 = new Producer("生产者C");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
