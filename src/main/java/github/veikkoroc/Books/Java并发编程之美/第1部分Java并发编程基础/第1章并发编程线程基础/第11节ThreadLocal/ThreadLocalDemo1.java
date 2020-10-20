package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第1章并发编程线程基础.第11节ThreadLocal;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/17 19:17
 */
public class ThreadLocalDemo1  {

    // 1.创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    // 2.打印ThreadLocal内容的函数
    static void print(String string){

        // 打印当前线程本地内存中localVariable变量的值
        System.out.println(string+":"+localVariable.get());

        // 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {

        // 3.创建线程One
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                // 设置线程One中本地变量localVariable的值
                localVariable.set("threadOne local variable");

                // 调用打印函数
                print("threadOne");

                // 打印本地变量的值
                System.out.println("threadOne remove after"+":"+localVariable.get());

            }
        });

        // 4.创建线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {

                // 设置线程two中本地变量localVariable的值
                localVariable.set("threadTwo local variable");

                //  调用打印函数
                print("threadTwo");

                // 打印本地变量的值
                System.out.println("threadTwo remove after"+":"+localVariable.get());

            }
        });

        // 5.启动线程
        threadOne.start();
        threadTwo.start();

    }

}
