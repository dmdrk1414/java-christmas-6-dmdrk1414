package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.order.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {
    private Management management;
    private BadgeManagement badgeManagement;
    private PaymentCalculator paymentCalculator;
    private Benefit benefit;
    private Orders orders;

    @BeforeEach
    void setUp() {
        this.management = new Management();
        this.badgeManagement = Config.badgeManagement();
        this.paymentCalculator = Config.paymentCalculator();
    }

    @Test
    void 주문_정보을_확인한다() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;
        Map<String, Integer> target = new HashMap<>();
        target.put("티본스테이크", 1);
        target.put("바비큐립", 1);
        target.put("초코케이크", 2);
        target.put("제로콜라", 1);

        // when
        Map<String, Integer> result = management.getOrderInformation(orderDay, orderString);

        // than
        assertThat(result).isEqualTo(target);
    }

    @Test
    void getOriginalOrderTotal() {
        // given

        // when

        // than

    }

    @Test
    void getFreebieMenu() {
        // given

        // when

        // than

    }

    @Test
    void getDiscountInformation() {
        // given

        // when

        // than

    }

    @Test
    void getTotalBenefit() {
        // given

        // when

        // than

    }

    @Test
    void getFinalPayment() {
        // given

        // when

        // than

    }

    @Test
    void getBadgeName() {
        // given

        // when

        // than

    }
}