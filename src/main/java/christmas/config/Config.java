package christmas.config;

import christmas.domain.discount.DDayDiscount;
import christmas.domain.discount.SpecialDayDiscount;
import christmas.domain.discount.WeekDayDiscount;
import christmas.domain.discount.WeekendDayDiscount;

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
}
