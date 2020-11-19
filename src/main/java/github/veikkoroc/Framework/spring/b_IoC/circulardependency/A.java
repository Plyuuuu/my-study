package github.veikkoroc.Framework.spring.b_IoC.circulardependency;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 13:11
 */
public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
