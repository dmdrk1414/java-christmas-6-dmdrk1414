package christmas.domain.discount;

import christmas.constant.discount.DiscountGroup;

public abstract class Discount {
    private final Integer orderDay;

    public Discount(Integer orderDay) {
        this.orderDay = orderDay;
    }

    abstract public Integer giveAmount();

    abstract public Boolean checkPeriod();

    abstract public String giveTitle();

    protected Integer getAmount(DiscountGroup discount) {
        return discount.getAmount(orderDay);
    }

    protected Boolean getConfirm(DiscountGroup discount) {
        return discount.hasDiscount(orderDay);
    }
}
