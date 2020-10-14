package github.veikkoroc.Z_codetest;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/13 21:07
 */
public class Test03 {
    public static void main(String[] args) {

        // 数字前加0，解析成其他数字

        long test = 0123;
        long test1 = 012;
        //  012-->10  0123--->83
        System.out.println(test);
        // 12
        System.out.println(test1);

        int test2 = 012;
        // 10
        System.out.println(test2);


        // float 可以由int转过来

        float f = -412;
        float f1 = 412;
        System.out.println(f);
        //int other = (int)true;

        double d = 0x12345678;
        System.out.println(d);
        //byte b = 128;
    }
}
