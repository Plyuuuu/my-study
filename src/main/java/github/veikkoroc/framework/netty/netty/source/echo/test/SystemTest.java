package github.veikkoroc.framework.netty.netty.source.echo.test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 11:45
 */
public class SystemTest {

    static final boolean SSL = System.getProperty("ssl") != null;

    public static void main(String[] args) {
        String ssl = System.getProperty("ssl");
        System.out.println(ssl);

        String host = System.getProperty("host", "127.0.0.1");
        System.out.println(host);

        System.out.println(SSL);
    }
}
