package christmas.domain.freebie;

import christmas.constant.Freebies;

import java.util.HashMap;
import java.util.Map;

public class Champagne {
    private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;

    public Map<String, Integer> makeChampagneCountInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = getChampagneName();
        Integer count = getChampagneCount();

        champagneInformation.put(champagne, count);

        return champagneInformation;
    }

    public Map<String, Integer> makeChampagnePriceInformation() {
        Map<String, Integer> champagneInformation = new HashMap<>();
        String champagne = getChampagneName();
        Integer price = getChampagnePrice();

        champagneInformation.put(champagne, price);

        return champagneInformation;
    }

    public Boolean isEligible(Integer totalOrderMoney) {
        return totalOrderMoney >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }

    public Integer getPrice() {
        return getChampagnePrice();
    }

    private Integer getChampagneCount() {
        return Freebies.CHAMPAGNE.getCount();
    }

    private String getChampagneName() {
        return Freebies.CHAMPAGNE.getName();
    }

    private Integer getChampagnePrice() {
        return Freebies.CHAMPAGNE.getPrice();
    }
}
