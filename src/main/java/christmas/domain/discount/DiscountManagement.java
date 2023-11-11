package christmas.domain.discount;

import christmas.config.Config;
import christmas.domain.Orders;

import java.util.List;

public class DiscountManagement {
    private List<Discount> discountManagement;

    public DiscountManagement(Integer orderDay, Orders orders) {
        discountManagement = List.of(
                Config.dDayDiscount(orderDay),
                Config.weekDayDiscount(orderDay, orders.getDessertCount()),
                Config.weekendDayDiscount(orderDay, orders.getMainCount()),
                Config.specialDayDiscount(orderDay)
        );
    }

    public Integer getTotalDiscount() {
        Integer totalDiscount = discountManagement.stream()
                .map(Discount::giveAmount)
                .reduce(0, Integer::sum);

        return totalDiscount;
    }

    // TODO: 11/11/23 해당하는 해택들의 이름, 돈 반환
}