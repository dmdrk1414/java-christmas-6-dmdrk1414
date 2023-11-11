package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class WeekDayDiscount extends Discount {
    public WeekDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.WEEK_DAY_DISCOUNT);

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        Boolean confirm = super.getConfirm(DiscountGroup.WEEK_DAY_DISCOUNT);

        return confirm;
    }
}
