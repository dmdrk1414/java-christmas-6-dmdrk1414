package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class WeekendDayDiscount extends Discount {
    private final Integer mainCount;

    public WeekendDayDiscount(Integer orderDay, Integer mainCount) {
        super(orderDay);
        this.mainCount = mainCount;
    }

    @Override
    public Integer giveAmount() {
        return getAmount();
    }

    @Override
    public String giveTitle() {
        return DiscountGroup.WEEKEND_DAY_DISCOUNT.getTitle();
    }

    private int getAmount() {
        return super.getAmount(DiscountGroup.WEEKEND_DAY_DISCOUNT) * mainCount;
    }
}
