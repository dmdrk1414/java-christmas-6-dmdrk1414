package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.order.Orders;

import java.util.Map;

public class Management {
    private final PaymentCalculator paymentCalculator;
    private Benefit benefit;
    private Orders orders;

    public Management() {
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

    public Map<String, Integer> getFreebieMenu() {
        Integer totalOrderMoney = orders.getOrderMoney();

        return benefit.getFreebieMenu(totalOrderMoney);
    }

    public Map<String, Integer> getBenefitInformation() {
        return benefit.getInformation();
    }

    public Integer getTotalBenefit() {
        return benefit.getTotalBenefit();
    }

    public Integer getFinalPayment() {
        Integer orderMoney = orders.getOrderMoney();
        Integer totalDiscount = benefit.getTotalDiscount();

        return paymentCalculator.estimateFinalPayment(orderMoney, totalDiscount);
    }

    public String getBadgeName() {
        return benefit.getBadgeName();
    }

    private void generateBenefit(Integer orderDay, Orders orders) {
        benefit = Config.benefit(orderDay, orders);
    }

    private void generateOrder(String orderString) {
        orders = Config.orders(orderString);
    }
}
