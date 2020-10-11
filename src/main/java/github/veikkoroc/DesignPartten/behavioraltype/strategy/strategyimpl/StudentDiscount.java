package github.veikkoroc.DesignPartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.DesignPartten.behavioraltype.strategy.strategy.Discount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 10:56
 */
public class StudentDiscount implements Discount {
    private final double DISCOUNT = 0.8;

    @Override
    public double calculate(double price) {
        System.out.println("学生票~");
        return price*DISCOUNT;
    }
}