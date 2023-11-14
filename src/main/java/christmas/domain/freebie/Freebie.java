package christmas.domain.freebie;

import christmas.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private static final String Freebie_Title = "증정 이벤트";
    private final Champagne champagne;

    public Freebie() {
        this.champagne = Config.champagne();
    }

    public Boolean isEligibleChampagne(Integer totalOrderMoney) {
        return isEligible(totalOrderMoney);
    }

    public Map<String, Integer> getPriceInformation(Integer totalOrderMoney) {
        Map<String, Integer> informations = new HashMap<>();
        Integer champagnePrice = champagne.getPrice();

        if (isEligible(totalOrderMoney)) {
            informations.put(Freebie_Title, champagnePrice);
        }

        return informations;
    }

    public Integer getChampagneBenefit(Integer totalOrderMoney) {
        Integer champagnePrice = 0;

        if (isEligible(totalOrderMoney)) {
            champagnePrice = getChampagnePrice();
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

    private Integer getChampagnePrice() {
        return champagne.getPrice();
    }
}
