package github.veikkoroc.designpartten.structuraltype.proxy.staticproxy;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:04
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("RealSubject request....");
    }
}
