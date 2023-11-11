package christmas.domain.freebie;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuGroup;
import christmas.domain.Orders;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;
    private String champagne;

    public Freebie() {
        this.champagne = Menu.CHAMPAGNE.getName();
    }

    public String getFreebie() {
        return champagne;
    }

    public Boolean isEligible(Orders orders) {
        System.out.println("orders.getOrderMoney() = " + orders.getOrderMoney());
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }

}
