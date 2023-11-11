package christmas.domain.freebie;

import christmas.constant.menu.Menu;
import christmas.domain.Orders;

public class Freebie {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_000;
    private String champagne;

    public Freebie() {
        this.champagne = Menu.CHAMPAGNE.getName();
    }

    public String getFreebie() {
        return champagne;
    }

    public Boolean isEligible(Orders orders) {
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }
}
