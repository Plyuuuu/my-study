package github.veikkoroc.designpartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.designpartten.behavioraltype.strategy.strategy.Discount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 11:03
 */
public class VIPDiscount implements Discount {
    private final double DISCOUNT = 0.7;
    @Override
    public double calculate(double price) {
        System.out.println("VIP用户~");
        System.out.println("VIP用户增加积分~");
        return price*DISCOUNT;
    }
}
