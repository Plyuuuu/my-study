package github.veikkoroc.JavaSE.enum_;

/**
 *
 * JDK1.5之前自定义枚举类
 *  （1、private final 声明枚举的参数，在创建完后参数不可更改）
 *  2、私有化类的构造器，保证在类的外部不能创建该类的对象
 *  3、在类的内部创建媒体类的实例，声明为 public static final
 *  4、对象如果有实例变量，应该声明为 private final，并且在构造器中初始化
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 10:13
 */
@SuppressWarnings(value = "all")
public class BeforeJDK5_Season {

    /**
     * 季节名称
     */
    private final String SEASONNAME;

    /**
     * 季节描述
     */
    private final String SEASONDESC;

    private BeforeJDK5_Season(String seasonname,String seasondeas){

        SEASONNAME = seasonname;
        SEASONDESC = seasondeas;

    }

    public static final BeforeJDK5_Season SPRING = new BeforeJDK5_Season("春天","春暖花开");
    public static final BeforeJDK5_Season SUMMER = new BeforeJDK5_Season("夏天","烈日炎炎");
    public static final BeforeJDK5_Season AUTUMN = new BeforeJDK5_Season("秋天","秋高气爽");
    public static final BeforeJDK5_Season WINTER = new BeforeJDK5_Season("冬天","白雪皑皑");

    @Override
    public String toString() {
        return "BeforeJDK5_Season{" +
                "SEASONNAME='" + SEASONNAME + '\'' +
                ", SEASONDESC='" + SEASONDESC + '\'' +
                '}';
    }
}
