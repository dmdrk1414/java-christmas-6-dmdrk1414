package christmas.domain.freebie;

import christmas.config.Config;
import christmas.constant.menu.Menu;
import christmas.domain.order.Orders;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;
    private Champagne champagne;

    public Freebie() {
        this.champagne = Config.champagne();
    }

    public Boolean isEligible(Orders orders) {
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }

    public Map<String, Integer> getInformations(Orders orders) {
        Map<String, Integer> informations = new HashMap<>();
        Map<String, Integer> champagnePriceInformation = champagne.makeChampagnePriceInformation();

        if (isEligible(orders)) {
            informations.putAll(champagnePriceInformation);
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

    public Map<String, Integer> getFreebieCount(Orders orders) {
        Map<String, Integer> freebies = new HashMap<>();
        Map<String, Integer> champagneCountInformation = champagne.makeChampagneCountInformation();

        if (isEligible(orders)) {
            freebies.putAll(champagneCountInformation);
        }

        return freebies;
    }
}
