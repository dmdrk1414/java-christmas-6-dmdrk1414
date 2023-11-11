package christmas.domain;

import christmas.constant.discount.DiscountGroup;

public class WeekendDayDiscount extends Discount {
    public WeekendDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.WEEKEND_DAY_DISCOUNT);

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        return null;
    }
}
