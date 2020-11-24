package github.veikkoroc.designpartten.behavioraltype.strategy.strategy;

/**
 *  折扣算法规范
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:55
 */
public interface Discount {
    /**
     * 计算价格抽象方法
     * @param price
     * @return
     */
    public double calculate(double price);
}
