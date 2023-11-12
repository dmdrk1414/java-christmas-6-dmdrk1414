package christmas.domain;

import christmas.config.Config;
import christmas.domain.discount.DiscountManagement;
import christmas.domain.freebie.Freebie;

import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private DiscountManagement discountManagement;
    private Freebie freebie;
    private Orders orders;
    private BadgeManagement badgeManagement;

    public Benefit(Integer orderDay, Orders orders) {
        this.discountManagement = Config.discountManagement(orderDay, orders);
        this.freebie = Config.freebie();
        this.orders = orders;
        badgeManagement = Config.badgeManagement();
    }

    // TODO: 11/12/23 order객체의 종속 관계 확인
    public Map<String, Integer> generateInformations() {
        Map<String, Integer> discountInformations = discountManagement.getInformations();
        Map<String, Integer> freebieInformations = freebie.getInformations(orders);
        Map<String, Integer> informations = new HashMap<>();

        informations.putAll(discountInformations);
        informations.putAll(freebieInformations);

        return informations;
    }


    public Boolean isEligibleFreebie() {
        return freebie.isEligible(orders);
    }

    public Integer getTotalAmount() {
        Integer totalAmount = 0;

        totalAmount = totalAmount + discountManagement.getTotalDiscount();
        totalAmount = totalAmount + freebie.getFreebiePrice(orders);

        return totalAmount;
    }

    public String getBadgeName() {
        Integer totalBenefit = getTotalAmount();
        return badgeManagement.getBadge(totalBenefit);
    }
}
