package christmas.config;

import christmas.domain.Management;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.order.OrderCalculator;
import christmas.domain.order.Orders;
import christmas.domain.discount.*;
import christmas.domain.freebie.Freebie;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.View;

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

    public static OrderCalculator calculator() {
        return new OrderCalculator();
    }

    public static Orders orders(String orderString) {
        return new Orders(orderString);
    }

    public static PaymentCalculator paymentCalculator() {
        return new PaymentCalculator();
    }

    public static Benefit benefit(Integer orderDay, Orders orders) {
        return new Benefit(orderDay, orders);
    }

    public static InputView inputView() {
        return new InputView();
    }

    public static OutputView outputView() {
        return new OutputView();
    }

    public static Management management() {
        return new Management();
    }

    public static View view() {
        return new View();
    }
}
