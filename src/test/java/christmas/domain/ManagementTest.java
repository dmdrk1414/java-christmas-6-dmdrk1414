package christmas.domain;

import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

class ManagementTest {
    private Management management;

    @BeforeEach
    void setUp() {
        management = new Management();
    }

    @DisplayName("주문 객체를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,바비큐립-1,양송이수프-2,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,양송이수프-1,타파스-1,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,시저샐러드-1,양송이수프-1,초코케이크-2,제로콜라-1",
            "티본스테이크-1,바비큐립-1,타파스-1,시저샐러드-1,초코케이크-2,제로콜라-1",
    })
    void giveOrderInformation(String orderString) {
        // given
        management.generateOrder(orderString);

        // when
        Map<String, Integer> result = management.getOrderInformation();

        // then

    }

    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 142000",
            "타파스-1제로콜라-1 , 142000",
    })
    void getOriginalOrderTotal(String ordersString, Integer total) {
        ordersString = TestUtill.insertComma(ordersString);
        management.generateOrder(ordersString);

        System.out.println(management.getOriginalOrderTotal());
    }
}