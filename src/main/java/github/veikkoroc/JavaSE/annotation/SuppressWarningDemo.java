package github.veikkoroc.JavaSE.annotation;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 8:48
 */
public class SuppressWarningDemo {
    public static void main(String[] args) {
        @SuppressWarnings(value = "unused") // unused 是固定写法?
        int a = 10;
    }
}
