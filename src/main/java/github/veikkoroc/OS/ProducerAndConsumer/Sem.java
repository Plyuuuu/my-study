package github.veikkoroc.OS.ProducerAndConsumer;

import java.util.concurrent.Semaphore;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 12:45
 */
public class Sem {
    /**
     *  多个 生产者互斥访问 1 个仓库
     */
    public static final Semaphore P_MUTEX = new Semaphore(1);
    /**
     *  多个 消费者互斥访问 1 个仓库
     */
    public static final Semaphore C_MUTEX = new Semaphore(1);

    /**
     * 仓库的 位置数,初始为10
     */
    public static final Semaphore SITE = new Semaphore(10);
    /**
     * 仓库的产品个数，初始为0
     */
    public static final Semaphore PRODUCT_COUNT = new Semaphore(0);
}
