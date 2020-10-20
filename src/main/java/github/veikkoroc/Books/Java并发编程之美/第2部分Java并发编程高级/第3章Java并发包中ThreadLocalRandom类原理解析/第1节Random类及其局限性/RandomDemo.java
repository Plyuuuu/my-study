package github.veikkoroc.Books.Java并发编程之美.第2部分Java并发编程高级.第3章Java并发包中ThreadLocalRandom类原理解析.第1节Random类及其局限性;

import java.util.Random;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 23:19
 */
public class RandomDemo {
    public static void main(String[] args) {

        // 1.创建一个默认种子的随机数生成器
        Random random = new Random();

        // 2.输出10个在0~5（包含0，不包含5）之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }

    }
}
