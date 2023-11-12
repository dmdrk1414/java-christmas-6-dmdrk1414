package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.freebie.Freebie;
import christmas.domain.order.Orders;

import java.util.Map;

public class Management {
    private BadgeManagement badgeManagement;
    private Benefit benefit;
    private PaymentCalculator paymentCalculator;
    private Orders orders;
    private Freebie freebie;

    public Management() {
        this.badgeManagement = Config.badgeManagement();
        this.paymentCalculator = Config.paymentCalculator();
        this.freebie = Config.freebie();
    }

    public void generateOrder(Integer orderDay, String orderString) {
        orders = Config.orders(orderString);
        generateBenefit(orderDay, orders);
    }

    private void generateBenefit(Integer orderDay, Orders orders) {
        benefit = Config.benefit(orderDay, orders);
    }

    public Map<String, Integer> getOrderInformation() {
        return orders.getOrderInformation();
    }

    public Integer getOriginalOrderTotal() {
        return orders.getOrderMoney();
    }

    public Map<String, Integer> getFreebieInformation() {
        return freebie.getInformations(orders);
    }

    public Map<String, Integer> getDiscountInformation() {
        return benefit.generateInformations();
    }


    public Integer getTotalDiscount() {
        return benefit.getTotalAmount();
    }

    public Integer getFinalPayment() {
        Integer finalPayment = paymentCalculator.estimateFinalPayment(getOriginalOrderTotal(), getTotalDiscount());

        return finalPayment;
    }

    public String getBadgeName() {
        return benefit.getBadgeName();
    }

    public Map<String, Integer> getFreebies() {
        return freebie.getFreebies(orders);
    }
}
