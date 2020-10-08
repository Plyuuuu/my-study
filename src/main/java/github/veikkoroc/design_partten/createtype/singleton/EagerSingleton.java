package github.veikkoroc.design_partten.createtype.singleton;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 22:41
 */
public class EagerSingleton {



    private int version;


    private static final EagerSingleton eagerSingleton = new EagerSingleton(1);

    private EagerSingleton(int i){
        this.version = i;
    }

    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }

}
