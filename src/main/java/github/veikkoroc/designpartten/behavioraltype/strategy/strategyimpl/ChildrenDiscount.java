package github.veikkoroc.designpartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.designpartten.behavioraltype.strategy.strategy.Discount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:58
 */
public class ChildrenDiscount implements Discount {
    private final double DISCOUNT = 10;
    private final double LOWEST_PRICE = 20;

    @Override
    public double calculate(double price) {
        if (price>=LOWEST_PRICE){
            System.out.println("儿童票~");
            return price-DISCOUNT;
        }
        System.out.println("票价太低，儿童不享受优惠了哦！");
        return price;
    }
}
