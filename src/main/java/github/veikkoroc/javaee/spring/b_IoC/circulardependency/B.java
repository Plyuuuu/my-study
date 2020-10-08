package github.veikkoroc.javaee.spring.b_IoC.circulardependency;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 13:11
 */
public class B {
    private A a;

    public B(A a) {
        this.a = a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
