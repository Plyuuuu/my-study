package github.veikkoroc.DesignPartten.behavioraltype.strategy.context;

import github.veikkoroc.DesignPartten.behavioraltype.strategy.strategy.Discount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 11:06
 */
public class MovieTicket {
    /**
     * 票价
     */
    private double price;
    /**
     * 折扣方法
     */
    private Discount discount;

    /**
     * 获取折扣后票价
     * @return
     */
    public double getPrice() {
        return discount.calculate(this.price);
    }

    /**
     * 设置票价
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    /**
     * 设置折扣方案
     * @param discount
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

