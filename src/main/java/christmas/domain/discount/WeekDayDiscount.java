package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class WeekDayDiscount extends Discount {
    private Integer dessertOrderCount;

    public WeekDayDiscount(Integer orderDay, Integer dessertCount) {
        super(orderDay);
        this.dessertOrderCount = dessertCount;
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.WEEK_DAY_DISCOUNT) * dessertOrderCount;

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        Boolean confirm = super.getConfirm(DiscountGroup.WEEK_DAY_DISCOUNT);

        return confirm;
    }
}
