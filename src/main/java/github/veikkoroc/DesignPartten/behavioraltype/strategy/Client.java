package github.veikkoroc.DesignPartten.behavioraltype.strategy;

import github.veikkoroc.DesignPartten.behavioraltype.strategy.context.MovieTicket;
import github.veikkoroc.DesignPartten.behavioraltype.strategy.strategyimpl.VIPDiscount;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 11:10
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setPrice(33);
        movieTicket.setDiscount(new VIPDiscount());
        System.out.println(movieTicket.getPrice());
    }
}
