package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第6节volatile关键字;

/**
 *
 * 使用synchronized关键字进行同步
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 10:31
 */
public class Demo2 {

    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized  void set(int value){
        this.value = value;
    }

}
