package christmas.domain.benefit;

import christmas.domain.order.Orders;
import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BenefitTest {
    private Benefit benefit;

    @BeforeEach
    void setUp() {
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);
    }

    @DisplayName("모든 해택에 관한 정보를 얻는다")
    @Test
    void getInformation() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Map<String, Integer> result = benefit.getInformation();

        // than
        assertThat(result.toString()).contains("{크리스마스 디데이 할인=1200, 평일 할인=4046, 특별 할인=1000, 증정 이벤트=25000}");
    }

    @DisplayName("모든 해택에 관한 정보를 얻는다_2")
    @Test
    void getInformation_2() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Map<String, Integer> result = benefit.getInformation();
        System.out.println(result);
        // than
        assertThat(result.toString()).contains("{}");
    }

    @DisplayName("날짜 기반 할인 총 액수를 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 6246",
            "타파스-1제로콜라-1, 0"
    })
    void getTotalDiscount(String orderString, Integer totalDiscount) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Integer result = benefit.getTotalDiscount();

        // than
        assertThat(result).isEqualTo(totalDiscount);
    }

    @DisplayName("혜택의 총액을 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 31246",
            "타파스-1제로콜라-1, 0"
    })
    void getTotalBenefit(String orderString, Integer totalDiscount) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Integer result = benefit.getTotalBenefit();

        // than
        assertThat(result).isEqualTo(totalDiscount);
    }

    @Test
    void getBadgeName() {
        // given
        // when
        // than
    }

    @Test
    void getFreebieCount() {
        // given
        // when
        // than
    }
}