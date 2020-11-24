package github.veikkoroc.designpartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.designpartten.behavioraltype.strategy.strategy.Discount;

/**
 *
 * 普通人算法
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 11:07
 */
public class Common implements Discount {
    @Override
    public double calculate(double price) {
        return price;
    }
}
