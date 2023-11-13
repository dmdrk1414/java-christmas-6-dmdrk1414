package christmas.domain.freebie;

import christmas.constant.Freebies;

import java.util.HashMap;
import java.util.Map;

public class Champagne {
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
}
