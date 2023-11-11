package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    @BeforeEach
    void setUp() {
    }

    @DisplayName("주문의 에피타이저 갯수를 반환하는 기능 수정")
    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,양송이수프-1,타파스-1,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,시저샐러드-1,양송이수프-1,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,타파스-1,시저샐러드-1,초코케이크-2,제로콜라-1",
    })
    void getAppetizerCount(String ordersString) {
        // given
        Orders orders = new Orders(ordersString);

        // when
        Integer result = orders.getAppetizerCount();

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("주문의 메인 갯수를 반환하는 기능 수정")
    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "바비큐립-1,해산물파스타-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "해산물파스타-1,크리스마스파스타-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "바비큐립-1,해산물파스타-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "해산물파스타-1,크리스마스파스타-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "크리스마스파스타-1,티본스테이크-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "티본스테이크-1,해산물파스타-1,양송이수프-2,초코케이크-2,제로콜라-1",
    })
    void getMainCount(String ordersString) {
        Orders orders = new Orders(ordersString);

        // when
        Integer result = orders.getMainCount();

        // then
        assertThat(result).isEqualTo(2);
    }
}