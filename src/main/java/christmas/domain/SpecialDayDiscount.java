package christmas.domain;

import christmas.constant.discount.DiscountGroup;

public class SpecialDayDiscount extends Discount {
    public SpecialDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.SPECIAL_DAY_DISCOUNT);

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        return null;
    }
}
