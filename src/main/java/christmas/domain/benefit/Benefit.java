package christmas.domain.benefit;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.discount.DiscountManagement;
import christmas.domain.freebie.Freebie;
import christmas.domain.order.Orders;

import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private final DiscountManagement discountManagement;
    private final Freebie freebie;
    private final Orders orders;
    private final BadgeManagement badgeManagement;

    public Benefit(Integer orderDay, Orders orders) {
        this.discountManagement = Config.discountManagement(orderDay, orders);
        this.freebie = Config.freebie();
        this.orders = orders;
        this.badgeManagement = Config.badgeManagement();
    }

    public Map<String, Integer> getInformation() {
        Integer totalOrderMoney = orders.getOrderMoney();
        Map<String, Integer> information = new HashMap<>();

        if (getTotalBenefit() != 0) {
            Map<String, Integer> discountInformation = discountManagement.getInformation();
            Map<String, Integer> freebieInformation = freebie.getPriceInformation(totalOrderMoney);

            information.putAll(discountInformation);
            information.putAll(freebieInformation);
        }

        return information;
    }

    public Integer getTotalDiscount() {
        Integer totalAmount = 0;

        totalAmount = totalAmount + discountManagement.getTotalDiscount();

        return totalAmount;
    }

    public Integer getTotalBenefit() {
        Integer totalAmount = 0;
        Integer totalOrderMoney = orders.getOrderMoney();

        totalAmount = totalAmount + discountManagement.getTotalDiscount();
        totalAmount = totalAmount + freebie.getChampagneBenefit(totalOrderMoney);

        return totalAmount;
    }

    public String getBadgeName() {
        Integer totalBenefit = getTotalBenefit();

        return badgeManagement.getBadge(totalBenefit);
    }

    public Map<String, Integer> getFreebieCount(Integer totalOrderMoney) {
        return freebie.getFreebieCount(totalOrderMoney);
    }
}
