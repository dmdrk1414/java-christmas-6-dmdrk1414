package christmas.config;

import christmas.domain.badge.BadgeManagement;
import christmas.domain.order.Calculator;
import christmas.domain.order.Orders;
import christmas.domain.discount.*;
import christmas.domain.freebie.Freebie;

import java.util.Map;

public class Config {
    public static DDayDiscount dDayDiscount(Integer orderDay) {
        return new DDayDiscount(orderDay);
    }

    public static WeekDayDiscount weekDayDiscount(Integer orderDay, Integer dessertCount) {
        return new WeekDayDiscount(orderDay, dessertCount);
    }

    public static WeekendDayDiscount weekendDayDiscount(Integer orderDay, Integer mainCount) {
        return new WeekendDayDiscount(orderDay, mainCount);
    }

    public static SpecialDayDiscount specialDayDiscount(Integer orderDay) {
        return new SpecialDayDiscount(orderDay);
    }

    public static DiscountManagement discountManagement(Integer orderDay, Orders orders) {
        return new DiscountManagement(orderDay, orders);
    }

    public static Freebie freebie() {
        return new Freebie();
    }

    public static BadgeManagement badgeManagement() {
        return new BadgeManagement();
    }

    public static Calculator calculator(Map<String, Integer> orders) {
        return new Calculator(orders);
    }
}
