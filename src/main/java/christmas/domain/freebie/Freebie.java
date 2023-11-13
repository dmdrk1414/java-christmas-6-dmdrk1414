package christmas.domain.freebie;

import christmas.config.Config;
import christmas.constant.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Freebie {
    private Champagne champagne;

    public Freebie() {
        this.champagne = Config.champagne();
    }

    public Boolean isEligibleChampagne(Integer totalOrderMoney) {
        return champagne.isEligible(totalOrderMoney);
    }

    public Map<String, Integer> getInformations(Integer totalOrderMoney) {
        Map<String, Integer> informations = new HashMap<>();
        Map<String, Integer> champagnePriceInformation = champagne.makeChampagnePriceInformation();

        if (isEligibleChampagne(totalOrderMoney)) {
            informations.putAll(champagnePriceInformation);
        }

        return informations;
    }

    // TODO: 11/12/23 과연 이방법이 맞는 것인가.

    public Integer getFreebiePrice(Integer totalOrderMoney) {
        Integer freebiePrice = 0;

        if (isEligibleChampagne(totalOrderMoney)) {
            freebiePrice = Menu.CHAMPAGNE.getPrice();
        }
        return freebiePrice;
    }

    public Map<String, Integer> getFreebieCount(Integer totalOrderMoney) {
        Map<String, Integer> freebies = new HashMap<>();
        Map<String, Integer> champagneCountInformation = champagne.makeChampagneCountInformation();

        if (isEligibleChampagne(totalOrderMoney)) {
            freebies.putAll(champagneCountInformation);
        }

        return freebies;
    }
}
