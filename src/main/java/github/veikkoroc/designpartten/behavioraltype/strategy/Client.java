package github.veikkoroc.designpartten.behavioraltype.strategy;

import github.veikkoroc.designpartten.behavioraltype.strategy.context.MovieTicket;
import github.veikkoroc.designpartten.behavioraltype.strategy.strategyimpl.VIPDiscount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 11:10
 */
public class Client {
    public static void main(String[] args) {
        // 创建电影票对象
        MovieTicket movieTicket = new MovieTicket();
        // 设置电影票票价
        movieTicket.setPrice(33);
        // 设置电影票折扣算法
        movieTicket.setDiscount(new VIPDiscount());
        // 输出折扣后的价格
        System.out.println(movieTicket.getPrice());
    }
}
