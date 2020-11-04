package github.veikkoroc.Books.Java并发编程之美.第2部分Java并发编程高级.第4章Java并发包中原子操作类原理剖析.第1节原子变量操作类;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 *  统计0的个数
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/30 0:03
 */
public class AtomicTest {

    // 创建Long类型原子计数器
    private static AtomicLong atomicLong = new AtomicLong();

    // 创建数据源
    private static Integer[] arrOne = new Integer[] {0,1,2,3,0,5,6,0,56,0};
    private static Integer[] arrTwo = new Integer[] {10,1,2,3,0,5,6,0,56,0};


    public static void main(String[] args) throws InterruptedException {

        // 创建线程One统计arrOne中0的个数
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrOne.length;
                for (int i = 0; i < size; i++) {
                    if (arrOne[i].intValue() == 0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        // 创建线程two统计数组arrayTwo中0的个数
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrTwo.length;
                for (int i = 0; i < size; i++) {
                    if (arrTwo[i] == 0){
                        atomicLong.incrementAndGet();

                    }
                }
            }
        });

        // 启动子线程
        thread.start();
        threadTwo.start();

        // 等待线程执行结束
        thread.join();
        threadTwo.join();

        System.out.println("count 0:"+atomicLong);

    }
}
