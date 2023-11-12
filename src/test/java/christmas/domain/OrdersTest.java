package christmas.domain;

import christmas.domain.order.Orders;
import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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


    @DisplayName("주문의 디저트 갯수를 반환하는 기능 수정")
    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,양송이수프-2,아이스크림-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-1,아이스크림-1,제로콜라-1",
    })
    void getDessertCount(String ordersString) {
        Orders orders = new Orders(ordersString);

        // when
        Integer result = orders.getDessertCount();

        // then
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("주문의 음료 갯수를 반환하는 기능 수정")
    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,제로콜라-1,레드와인-1",
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,레드와인-1,샴페인-1",
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,샴페인-1,제로콜라-1",
    })
    void getBeverageCount(String ordersString) {
        Orders orders = new Orders(ordersString);

        // when
        Integer result = orders.getDessertCount();

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("주문을 할때 준문의 총금액 구현 기능 추가")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 142000",
            "타파스-1제로콜라-1, 8500",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 93000",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 145000",
            "해산물파스타-1크리스마스파스타-1아이스크림-2샴페인-1, 95000",
            "양송이수프-1티본스테이크-2아이스크림-2샴페인-1, 151000",
            "타파스-1크리스마스파스타-1아이스크림-3제로콜라-2, 51500",
            "시저샐러드-2바비큐립-1초코케이크-2제로콜라-1, 103000",
            "양송이수프-1바비큐립-1해산물파스타-2샴페인-1, 155000",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, 135000",
            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, 111000",
            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, 86000",
            "시저샐러드-2바비큐립-1아이스크림-3샴페인-2, 135000",
            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, 86000",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, 135000",
            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, 111000",
            "양송이수프-1바비큐립-1초코케이크-2샴페인-1, 115000",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, 135000",
            "시저샐러드-2크리스마스파스타-1아이스크림-2샴페인-1, 76000"
    })
    void getOrderMoney(String ordersString, Integer total) {
        ordersString = TestUtill.insertComma(ordersString);
        Orders orders = new Orders(ordersString);

        // when
        Integer result = orders.getOrderMoney();

        // then
        assertThat(result).isEqualTo(total);
    }

}