package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class SpecialDayDiscount extends Discount {
    public SpecialDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        return super.getAmount(DiscountGroup.SPECIAL_DAY_DISCOUNT);
    }


    @Override
    public String giveTitle() {
        return DiscountGroup.SPECIAL_DAY_DISCOUNT.getTitle();
    }
}
