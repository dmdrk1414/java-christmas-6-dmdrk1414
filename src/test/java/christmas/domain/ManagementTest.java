package christmas.domain;

import christmas.config.Config;
import christmas.domain.badge.BadgeManagement;
import christmas.domain.benefit.Benefit;
import christmas.domain.calculator.PaymentCalculator;
import christmas.domain.order.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {
    private BadgeManagement badgeManagement;
    private PaymentCalculator paymentCalculator;
    private Benefit benefit;
    private Orders orders;

    @BeforeEach
    void setUp() {
        this.badgeManagement = Config.badgeManagement();
        this.paymentCalculator = Config.paymentCalculator();
    }

    @Test
    void getOrderInformation() {
        // given

        // when

        // than

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