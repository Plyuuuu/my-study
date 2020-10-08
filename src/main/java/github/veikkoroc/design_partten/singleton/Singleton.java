package github.veikkoroc.design_partten.singleton;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 11:29
 */
public class Singleton {

    /**
     * volatile 可以禁止指令重排序
     */
    private volatile static  Singleton singleton;

    private  Singleton(){

    }
    public static Singleton getInstance(){
        //双重检验锁
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
