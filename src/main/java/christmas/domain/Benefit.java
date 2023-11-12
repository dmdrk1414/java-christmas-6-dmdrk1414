package christmas.domain;

import christmas.config.Config;
import christmas.domain.discount.DiscountManagement;
import christmas.domain.freebie.Freebie;

import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private DiscountManagement discountManagement;
    private Freebie freebie;
    private Orders orders;

    public Benefit(Integer orderDay, Orders orders) {
        this.discountManagement = Config.discountManagement(orderDay, orders);
        this.freebie = Config.freebie();
        this.orders = orders;
    }

    // TODO: 11/12/23 해택이름 (할인과 증정품 반환)
    // <혜택 내역>
    // 크리스마스 디데이 할인: -1,200원
    // 평일 할인: -4,046원
    // 특별 할인: -1,000원
    // 증정 이벤트: -25,000원
    public Map<String, Integer> generateInformations() {
        Map<String, Integer> discountInformations = discountManagement.getInformations();
        Map<String, Integer> freebieInformations = freebie.getInformations(orders);
        Map<String, Integer> informations = new HashMap<>();

        informations.putAll(discountInformations);
        informations.putAll(freebieInformations);

        return informations;
    }


    // TODO: 11/12/23 샴페인 1개 증정
    // TODO: 11/12/23 총해택 금액 (샴페인 추가, 할인)
}
