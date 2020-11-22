package github.veikkoroc.designpartten.createtype.singleton;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 11:29
 */
public class LazySingleton {

    /**
     * volatile 可以禁止指令重排序
     */
    private volatile static LazySingleton singleton;

    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        //双重检验锁
        if (singleton == null){
            synchronized (LazySingleton.class){
                if (singleton == null){
                    singleton = new LazySingleton();
                }
            }
        }

        return singleton;
    }

}
