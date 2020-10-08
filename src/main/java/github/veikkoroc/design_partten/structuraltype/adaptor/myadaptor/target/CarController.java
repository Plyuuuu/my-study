package github.veikkoroc.design_partten.structuraltype.adaptor.myadaptor.target;

/**
 * 被适配的目标对象
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/8 23:42
 */
public abstract class CarController {

    public void move(){
        System.out.println("玩具车移动...");
    }

    /**
     * 发出警笛声音
     */
    public abstract void phonate();

    /**
     * 灯光闪烁
     */
    public abstract void twinkle();
}
