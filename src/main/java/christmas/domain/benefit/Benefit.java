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

    // TODO: 11/12/23 order객체의 종속 관계 확인
    public Map<String, Integer> generateInformations() {
        Integer totalOrderMoney = orders.getOrderMoney();
        Map<String, Integer> informations = new HashMap<>();
        Map<String, Integer> discountInformations = discountManagement.getInformations();
        Map<String, Integer> freebieInformations = freebie.getPriceInformations(totalOrderMoney);

        if (getTotalAmount() != 0) {
            informations.putAll(discountInformations);
            informations.putAll(freebieInformations);
        }

        return informations;
    }

    public Boolean isEligibleFreebie() {
        Integer totalOrderMoney = orders.getOrderMoney();

        return freebie.isEligibleChampagne(totalOrderMoney);
    }

    public Integer getTotalAmount() {
        Integer totalAmount = 0;
        Integer totalOrderMoney = orders.getOrderMoney();

        totalAmount = totalAmount + discountManagement.getTotalDiscount();
        totalAmount = totalAmount + freebie.getChampagnePrice(totalOrderMoney);

        return totalAmount;
    }

    public String getBadgeName() {
        Integer totalBenefit = getTotalAmount();

        return badgeManagement.getBadge(totalBenefit);
    }
}
