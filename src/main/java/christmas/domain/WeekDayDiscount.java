package christmas.domain;

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

    // TODO: 11/11/23 커밋할때 지우일
    @Override
    public Boolean checkPeriod() {
        Boolean confirm = super.getConfirm(DiscountGroup.WEEK_DAY_DISCOUNT);

        return confirm;
    }
}
