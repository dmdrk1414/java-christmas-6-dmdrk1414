package christmas.domain;

import christmas.constant.discount.DiscountGroup;

public abstract class Discount {
    private Integer orderDay;

    public Discount(Integer orderDay) {
        this.orderDay = orderDay;
    }

    abstract public Integer giveAmount();

    abstract public Boolean checkPeriod();

    protected Integer getAmount(DiscountGroup discount) {
        return discount.getAmount(orderDay);
    }

    protected Boolean getConfirm(DiscountGroup discount) {
        return discount.hasDiscount(orderDay);
    }
}
