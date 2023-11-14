package christmas.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {
    private OrderCalculator orderCalculator;

    @BeforeEach
    void setUp() {
        this.orderCalculator = new OrderCalculator();
    }

    @Test
    void 해택_적용전_주문의_가격을_확인한다_1() {
        // given
        Map<String, Integer> orders = new HashMap<>();
        orders.put("티본스테이크", 1);
        orders.put("바비큐립", 1);
        orders.put("초코케이크", 2);
        orders.put("제로콜라", 1);

        // when
        Integer result = orderCalculator.getOrderMoney(orders);

        // than
        assertThat(result).isEqualTo(142_000);
    }


    @Test
    void 해택_적용전_주문의_가격을_확인한다_2() {
        // given
        Map<String, Integer> orders = new HashMap<>();
        orders.put("타파스", 1);
        orders.put("제로콜라", 1);

        // when
        Integer result = orderCalculator.getOrderMoney(orders);

        // than
        assertThat(result).isEqualTo(8_500);
    }

    @Test
    void 해택_적용전_주문의_가격을_확인한다_3() {
        // given
        Map<String, Integer> orders = new HashMap<>();
        orders.put("티본스테이크", 3);
        orders.put("바비큐립", 3);
        orders.put("샴페인", 2);
        orders.put("제로콜라", 1);

        // when
        Integer result = orderCalculator.getOrderMoney(orders);

        // than
        assertThat(result).isEqualTo(380_000);
    }
}