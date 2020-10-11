package github.veikkoroc.DesignPartten.structuraltype.proxy.staticproxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:05
 */
public class Proxy extends Subject{

    RealSubject realSubject = new RealSubject();

    @Override
    public void request() {
        System.out.println("Before...");
        realSubject.request();
        System.out.println("After...");
    }
}
