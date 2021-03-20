package github.veikkoroc.JavaSE.enum_;

/**
 *
 * 使用 1.5 enum 类型
 *  1、声明属性，private final 修饰
 *  2、私有化构造器，并且给对象属性赋值
 *  3、提供当前枚举类的对象，多个对象用逗号隔开，末尾对象用分号结束【注意：必须放最前面】
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/15 10:26
 */
@SuppressWarnings(value = "all")
public enum Season {

    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");

    /**
     * 季节名称
     */
    private final String SEASONNAME;

    /**
     * 季节描述
     */
    private final String SEASONDESC;

    private Season(String seasonname,String seasondesc){
        this.SEASONNAME = seasonname;
        this.SEASONDESC = seasondesc;
    }


    @Override
    public String toString() {
        return "Season{" +
                "SEASONNAME='" + SEASONNAME + '\'' +
                ", SEASONDESC='" + SEASONDESC + '\'' +
                '}';
    }
}
