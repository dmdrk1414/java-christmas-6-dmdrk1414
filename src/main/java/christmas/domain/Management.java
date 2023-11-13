package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.order.Orders;

import java.util.Map;

public class Management {
    private final BadgeManagement badgeManagement;
    private final PaymentCalculator paymentCalculator;
    private Benefit benefit;
    private Orders orders;

    public Management() {
        this.badgeManagement = Config.badgeManagement();
        this.paymentCalculator = Config.paymentCalculator();
    }

    public Map<String, Integer> getOrderInformation(Integer orderDay, String orderString) {
        generateOrder(orderString);
        generateBenefit(orderDay, orders);

        return orders.getOrderInformation();
    }

    public Integer getOriginalOrderTotal() {
        return orders.getOrderMoney();
    }

    public Map<String, Integer> getDiscountInformation() {
        return benefit.generateInformations();
    }

    public Integer getTotalDiscount() {
        return benefit.getTotalAmount();
    }

    public Integer getFinalPayment() {
        return paymentCalculator.estimateFinalPayment(getOriginalOrderTotal(), getTotalDiscount());
    }

    public String getBadgeName() {
        return benefit.getBadgeName();
    }

    public Map<String, Integer> getFreebies() {
        Integer totalOrderMoney = orders.getOrderMoney();

        return benefit.getFreebieCount(totalOrderMoney);
    }

    private void generateBenefit(Integer orderDay, Orders orders) {
        benefit = Config.benefit(orderDay, orders);
    }

    private void generateOrder(String orderString) {
        orders = Config.orders(orderString);
    }
}
