package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.freebie.Freebie;
import christmas.domain.order.Orders;

import java.util.Map;

public class Management {
    private BadgeManagement badgeManagement;
    private Benefit benefit; // 주문 이후에
    private PaymentCalculator paymentCalculator;
    private Orders orders; // 입력받은후에
    private Freebie freebie;

    public Management() {
        this.badgeManagement = Config.badgeManagement();
        this.paymentCalculator = Config.paymentCalculator();
        this.freebie = Config.freebie();
    }

    public void generateOrder(Integer orderDay, String orderString) {
        orders = Config.orders(orderString);
        generateBenefit(orderDay, orders);
    }

    private void generateBenefit(Integer orderDay, Orders orders) {
        benefit = Config.benefit(orderDay, orders);
    }

    // <주문 메뉴>
    // 티본스테이크 1개
    // 바비큐립 1개
    // 초코케이크 2개
    // 제로콜라 1개
    // 주문 메뉴
    public Map<String, Integer> getOrderInformation() {
        return orders.getOrderInformation();
    }


    // <할인 전 총주문 금액>
    // 142,000원
    public Integer getOriginalOrderTotal() {
        return orders.getOrderMoney();
    }

    // <총혜택 금액
    // <증정 메뉴>
    // 샴페인 1개
    public Map<String, Integer> getFreebieInformation() {
        return freebie.getInformations(orders);
    }

    // <혜택 내역>
    // 크리스마스 디데이 할인: -
    //    // <총혜택 금액1,200원
    // 평일 할인: -4,046원
    // 특별 할인: -1,000원
    // 증정 이벤트: -25,000원
    public Map<String, Integer> getDiscountInformation() {
        return benefit.generateInformations();
    }


    // <총혜택 금액>
    // -31,246원

    // <할인 후 예상 결제 금액>
    // 135,754원

    // <12월 이벤트 배지>
    // 산타
}
