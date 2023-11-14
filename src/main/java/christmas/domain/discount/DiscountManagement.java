package christmas.domain.discount;

import christmas.config.Config;
import christmas.domain.order.Orders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountManagement {
    private static final Integer CONDITION_DISCOUNT_MONEY = 10000;
    private static final Integer ZERO_DISCOUNT = 0;
    private final List<Discount> discountManagement;
    private final Orders orders;

    public DiscountManagement(Integer orderDay, Orders orders) {
        this.discountManagement = List.of(
                Config.dDayDiscount(orderDay),
                Config.weekDayDiscount(orderDay, orders.getDessertCount()),
                Config.weekendDayDiscount(orderDay, orders.getMainCount()),
                Config.specialDayDiscount(orderDay)
        );
        this.orders = orders;
    }

    public Integer getTotalDiscount() {
        if (isConditionDiscount()) {
            return calculatorTotalDiscount();
        }

        return 0;
    }

    public Map<String, Integer> getInformation() {
        Map<String, Integer> informations = new HashMap<>();

        for (Discount discount : discountManagement) {
            String discountTitle = discount.giveTitle();
            Integer discountAmount = discount.giveAmount();

            if (isCondition(discountAmount)) {
                informations.put(discountTitle, discountAmount);
            }
        }

        return informations;
    }

    private boolean isCondition(Integer discountAmount) {
        return isConditionDiscount() && isNotZeroDiscount(discountAmount);
    }

    private boolean isNotZeroDiscount(Integer discountAmount) {
        return discountAmount != ZERO_DISCOUNT;
    }

    private boolean isConditionDiscount() {
        return orders.getOrderMoney() >= CONDITION_DISCOUNT_MONEY;
    }

    private Integer calculatorTotalDiscount() {
        return discountManagement.stream()
                .map(Discount::giveAmount)
                .reduce(0, Integer::sum);
    }
}