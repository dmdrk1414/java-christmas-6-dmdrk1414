package christmas.domain.freebie;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuGroup;
import christmas.domain.order.Orders;

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
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }

    public Map<String, Integer> getInformations(Orders orders) {
        Map<String, Integer> informations = new HashMap<>();

        if (isEligible(orders)) {
            Integer shampagnePrice = MenuGroup.BEVERAGE.getMenuPrice(champagne);

            informations.put(champagne, shampagnePrice);
        }

        return informations;
    }

    // TODO: 11/12/23 과연 이방법이 맞는 것인가.
    public Integer getFreebiePrice(Orders orders) {
        Integer freebiePrice = 0;

        if (isEligible(orders)) {
            freebiePrice = Menu.CHAMPAGNE.getPrice();
        }
        return freebiePrice;
    }
}
