package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第6节volatile关键字;

/**
 *
 * 没有适当的同步措施
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 10:27
 */
public class Demo1 {

    private int value;

    public int get(){
        return value;
    }

    public void set(int value){
        this.value = value;
    }

}
