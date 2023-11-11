package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class DDayDiscount extends Discount {
    public DDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        Integer amount = super.getAmount(DiscountGroup.D_DAY_DISCOUNT);

        return amount;
    }

    @Override
    public Boolean checkPeriod() {
        Boolean confirm = super.getConfirm(DiscountGroup.D_DAY_DISCOUNT);

        return confirm;
    }
}
