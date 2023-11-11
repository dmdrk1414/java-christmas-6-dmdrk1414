package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class WeekendDayDiscount extends Discount {
    private Integer mainCount;

    public WeekendDayDiscount(Integer orderDay, Integer mainCount) {
        super(orderDay);
        this.mainCount = mainCount;
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.WEEKEND_DAY_DISCOUNT) * mainCount;

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        Boolean confirm = super.getConfirm(DiscountGroup.WEEKEND_DAY_DISCOUNT);

        return confirm;
    }

    @Override
    public String giveTitle() {
        return DiscountGroup.WEEKEND_DAY_DISCOUNT.getTitle();
    }
}
