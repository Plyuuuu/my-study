package github.veikkoroc.JavaSE.enum_;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 10:38
 */
public class SeasonTest {
    public static void main(String[] args) {
        BeforeJDK5_Season autumn = BeforeJDK5_Season.AUTUMN;
        System.out.println(autumn);

        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
