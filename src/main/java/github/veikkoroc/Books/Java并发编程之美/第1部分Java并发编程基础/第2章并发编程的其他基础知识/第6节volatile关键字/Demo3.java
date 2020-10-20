package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第6节volatile关键字;

/**
 *
 * 使用volatile进行同步
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 10:32
 */
public class Demo3 {

    private volatile int value;

    public int get(){
        return value;
    }

    public void set(){
        this.value = value;
    }

}
