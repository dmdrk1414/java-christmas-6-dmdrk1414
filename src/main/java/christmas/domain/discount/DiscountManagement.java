package christmas.domain.discount;

import christmas.config.Config;
import christmas.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountManagement {
    private List<Discount> discountManagement;

    // TODO: 11/11/23 매개변수 생각 dessert와 메인 메뉴관리
    public DiscountManagement(Integer orderDay, Order order) {
        discountManagement = List.of(
                Config.dDayDiscount(orderDay),
                Config.weekDayDiscount(orderDay, order.getDessertCount()),
                Config.weekendDayDiscount(orderDay, order.getMainCount()),
                Config.specialDayDiscount(orderDay)
        );
    }

    public Integer getTotalDiscount() {
        Integer totalDiscount = discountManagement.stream()
                .map(Discount::giveAmount)
                .reduce(0, Integer::sum);

        // TODO: 11/11/23 삭제
        discountManagement.stream()
                .forEach(discount -> System.out.println(discount.giveAmount()));

        discountManagement.stream()
                .peek(discount -> System.out.println(discount.giveAmount()));

        return totalDiscount;
    }
}