package christmas.domain.freebie;

import christmas.constant.Freebies;

import java.util.HashMap;
import java.util.Map;

public class Champagne {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;

    public Map<String, Integer> makeChampagneCountInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = Freebies.CHAMPAGNE.getName();
        Integer count = Freebies.CHAMPAGNE.getCount();

        champagneInformation.put(champagne, count);

        return champagneInformation;
    }

    public Map<String, Integer> makeChampagnePriceInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = Freebies.CHAMPAGNE.getName();
        Integer price = Freebies.CHAMPAGNE.getPrice();

        champagneInformation.put(champagne, price);

        return champagneInformation;
    }

    public Boolean isEligible(Integer totalOrderMoney) {
        return totalOrderMoney >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }
}
