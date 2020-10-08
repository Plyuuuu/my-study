package github.veikkoroc.design_partten.createtype.singleton;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 22:48
 */
public class EagerSingletonTest {
    public static void main(String[] args) {
        EagerSingleton instance = EagerSingleton.getInstance();
        EagerSingleton instance1 = EagerSingleton.getInstance();
        System.out.println(instance==instance1);
    }
}
