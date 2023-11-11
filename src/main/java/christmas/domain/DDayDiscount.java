package christmas.domain;

import christmas.constant.discount.DiscountGroup;

public class DDayDiscount {
    private Integer orderDay;

    public DDayDiscount(Integer orderDay) {
        this.orderDay = orderDay;
    }

    public Integer giveAmount() {
        Integer amount = DiscountGroup.D_DAY_DISCOUNT.getAmount(orderDay);

        return amount;
    }

    public Boolean checkPeriod() {
        Boolean confirm = DiscountGroup.D_DAY_DISCOUNT.hasDiscount(orderDay);

        return confirm;
    }
}
