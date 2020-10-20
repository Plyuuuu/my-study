package github.veikkoroc.Books.Java并发编程之美.第1部分Java并发编程基础.第2章并发编程的其他基础知识.第10节Java指令重排序;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/18 21:00
 */
public  class Demo1 {



    public static class ReadThread extends Thread{
        @Override
        public void run() {

            // 线程被打断了就退出
            while (!Thread.currentThread().isInterrupted()){

                if (read){
                    System.out.println(num+num);
                }
                System.out.println("read thread...");
            }
        }
    }

    public static class WriteThread extends Thread{
        @Override
        public void run() {
            num = 2;
            read = true;
            System.out.println("WriteThread set over...");
        }
    }

    private volatile static boolean read = false;

    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        ReadThread readThread = new ReadThread();
        readThread.start();

        WriteThread writeThread = new WriteThread();
        writeThread.start();

        Thread.sleep(10);
        readThread.interrupt();
        System.out.println("main over...");


    }


}
