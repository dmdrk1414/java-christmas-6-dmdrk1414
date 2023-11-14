package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class WeekDayDiscount extends Discount {
    private final Integer dessertOrderCount;

    public WeekDayDiscount(Integer orderDay, Integer dessertCount) {
        super(orderDay);
        this.dessertOrderCount = dessertCount;
    }

    @Override
    public Integer giveAmount() {
        return getAmount();
    }


    @Override
    public String giveTitle() {
        return DiscountGroup.WEEK_DAY_DISCOUNT.getTitle();
    }

    private int getAmount() {
        return super.getAmount(DiscountGroup.WEEK_DAY_DISCOUNT) * dessertOrderCount;
    }
}
