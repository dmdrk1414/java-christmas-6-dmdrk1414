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
    void 주문의_원래의_가격을_확인한다() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getOriginalOrderTotal();

        // than
        assertThat(result).isEqualTo(142_000);
    }

    @Test
    void 주문의_원래의_가격을_확인한다_2() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getOriginalOrderTotal();

        // than
        assertThat(result).isEqualTo(8_500);
    }

    @Test
    void 증정품의_메뉴를_확인한다_증정품이_있는_경우() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;
        Map<String, Integer> target = new HashMap<>();
        target.put("샴페인", 1);

        // when
        management.getOrderInformation(orderDay, orderString);
        Map<String, Integer> result = management.getFreebieMenu();

        // than
        assertThat(result).isEqualTo(target);
    }

    @Test
    void 증정품의_메뉴를_확인한다_증정품이_없는경우() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Map<String, Integer> result = management.getFreebieMenu();

        // than
        assertThat(result).isEmpty();
    }

    @Test
    void 주문_날짜에_의한_모든_혜택의_정보를_확인한다_혜택이_있는경우() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;
        Map<String, Integer> target = new HashMap<>();
        target.put("크리스마스 디데이 할인", 1_200);
        target.put("평일 할인", 4_046);
        target.put("특별 할인", 1_000);
        target.put("증정 이벤트", 25_000);

        // when
        management.getOrderInformation(orderDay, orderString);
        Map<String, Integer> result = management.getBenefitInformation();

        // than
        assertThat(result).isEqualTo(target);
    }

    @Test
    void 주문_날짜에_의한_모든_혜택의_정보를_확인한다_혜택이_없는경우() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Map<String, Integer> result = management.getBenefitInformation();

        // than
        assertThat(result).isEmpty();
    }

    @Test
    void 총혜택_금액을_확인한다_혜택이_있는경우() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getTotalBenefit();

        // than
        assertThat(result).isEqualTo(31_246);
    }

    @Test
    void 총혜택_금액을_확인한다_혜택이_없는경우() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getTotalBenefit();

        // than
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 할인_후_예상_결제_금액을_확인한다_할인이_있는_경우() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getFinalPayment();

        // than
        assertThat(result).isEqualTo(135_754);
    }

    @Test
    void 할인_후_예상_결제_금액을_확인한다_할인이_없는_경우() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Integer orderDay = 3;

        // when
        management.getOrderInformation(orderDay, orderString);
        Integer result = management.getFinalPayment();

        // than
        assertThat(result).isEqualTo(8_500);
    }

    @Test
    void getBadgeName() {
        // given

        // when

        // than

    }
}