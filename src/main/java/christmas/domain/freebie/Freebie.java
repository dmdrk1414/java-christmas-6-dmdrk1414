package christmas.domain.freebie;

import christmas.constant.Freebies;
import christmas.constant.menu.Menu;
import christmas.domain.order.Orders;

import java.util.HashMap;
import java.util.Map;

// TODO: 11/13/23 고민 
public class Freebie {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;

    public Boolean isEligible(Orders orders) {
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }

    public Map<String, Integer> getInformations(Orders orders) {
        Map<String, Integer> informations = new HashMap<>();

        if (isEligible(orders)) {
            informations.putAll(makeChampagnePriceInformation());
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

    public Map<String, Integer> getFreebies(Orders orders) {
        Map<String, Integer> freebies = new HashMap<>();

        if (isEligible(orders)) {
            freebies.putAll(makeChampagneCountInformation());
        }

        return freebies;
    }

    private Map<String, Integer> makeChampagneCountInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = Freebies.CHAMPAGNE.getName();
        Integer count = Freebies.CHAMPAGNE.getCount();

        champagneInformation.put(champagne, count);

        return champagneInformation;
    }

    private Map<String, Integer> makeChampagnePriceInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = Freebies.CHAMPAGNE.getName();
        Integer price = Freebies.CHAMPAGNE.getPrice();

        champagneInformation.put(champagne, price);

        return champagneInformation;
    }
}
