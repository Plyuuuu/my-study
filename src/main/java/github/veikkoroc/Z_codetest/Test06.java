package github.veikkoroc.Z_codetest;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 13:24
 */
public class Test06 {
    public static void main(String[] args) {

        int num = 2;
        switch (num) {
            case 1:
                ++num;
            case 2:
                ++num;
            case 3:
                ++num;
            default:
                ++num;
                break;
        }
        System.out.println(num);
    }
}
