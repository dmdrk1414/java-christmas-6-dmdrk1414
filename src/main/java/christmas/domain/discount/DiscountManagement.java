package christmas.domain.discount;

import christmas.config.Config;
import christmas.domain.order.Orders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountManagement {
    private static final Integer CONDITION_DISCOUNT_MONEY = 10000;
    private List<Discount> discountManagement;
    private Orders orders;

    public DiscountManagement(Integer orderDay, Orders orders) {
        discountManagement = List.of(
                Config.dDayDiscount(orderDay),
                Config.weekDayDiscount(orderDay, orders.getDessertCount()),
                Config.weekendDayDiscount(orderDay, orders.getMainCount()),
                Config.specialDayDiscount(orderDay)
        );
        this.orders = orders;
    }

    public Integer getTotalDiscount() {
        Integer totalDiscount = 0;

        if (orders.getOrderMoney() >= CONDITION_DISCOUNT_MONEY) {
            totalDiscount = discountManagement.stream()
                    .map(Discount::giveAmount)
                    .reduce(0, Integer::sum);
        }

        return totalDiscount;
    }

    public Map<String, Integer> getInformations() {
        Map<String, Integer> informations = new HashMap<>();

        for (Discount discount : discountManagement) {
            String discountTitle = discount.giveTitle();
            Integer discountAmount = 0;

            if (orders.getOrderMoney() >= CONDITION_DISCOUNT_MONEY) {
                discountAmount = discount.giveAmount();
            }
            informations.put(discountTitle, discountAmount);
        }
        return informations;
    }
}