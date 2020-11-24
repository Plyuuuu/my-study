package github.veikkoroc.designpartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.designpartten.behavioraltype.strategy.strategy.Discount;

/**
 * 学生票算法
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
