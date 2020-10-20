package github.veikkoroc.Books.Java并发编程之美.第2部分Java并发编程高级.第3章Java并发包中ThreadLocalRandom类原理解析.第2节ThreadLocalRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 23:34
 */
public class ThreadLocalRandomDemo {
    public static void main(String[] args) {

        // 获取一个随机数生成器
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        // 输出10个在0~5（包含0，不包含5）之间的随机数
        for (int i = 0;i<10;i++){
            System.out.println(threadLocalRandom.nextInt(5));
        }

    }
}
