package christmas.domain.freebie;

import christmas.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private final Champagne champagne;

    public Freebie() {
        this.champagne = Config.champagne();
    }

    public Boolean isEligibleChampagne(Integer totalOrderMoney) {
        return isEligible(totalOrderMoney);
    }

    public Map<String, Integer> getPriceInformations(Integer totalOrderMoney) {
        Map<String, Integer> informations = new HashMap<>();
        Map<String, Integer> champagnePriceInformation = champagne.makeChampagnePriceInformation();

        if (isEligible(totalOrderMoney)) {
            informations.putAll(champagnePriceInformation);
        }

        return informations;
    }

    public Integer getChampagneBenefit(Integer totalOrderMoney) {
        Integer champagnePrice = 0;

        if (isEligible(totalOrderMoney)) {
            champagnePrice = champagne.getPrice();
        }

        return champagnePrice;
    }

    public Map<String, Integer> getFreebieCount(Integer totalOrderMoney) {
        Map<String, Integer> freebies = new HashMap<>();
        Map<String, Integer> champagneCountInformation = champagne.makeChampagneCountInformation();

        if (isEligible(totalOrderMoney)) {
            freebies.putAll(champagneCountInformation);
        }

        return freebies;
    }

    private Boolean isEligible(Integer totalOrderMoney) {
        return champagne.isEligible(totalOrderMoney);
    }
}
