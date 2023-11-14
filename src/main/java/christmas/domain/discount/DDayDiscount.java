package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public class DDayDiscount extends Discount {
    public DDayDiscount(Integer orderDay) {
        super(orderDay);
    }

    @Override
    public Integer giveAmount() {
        return super.getAmount(DiscountGroup.D_DAY_DISCOUNT);
    }


    @Override
    public String giveTitle() {
        return DiscountGroup.D_DAY_DISCOUNT.getTitle();
    }
}
