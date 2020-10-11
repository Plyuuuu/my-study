package github.veikkoroc.DesignPartten.behavioraltype.strategy.strategyimpl;

import github.veikkoroc.DesignPartten.behavioraltype.strategy.strategy.Discount;

/**
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
