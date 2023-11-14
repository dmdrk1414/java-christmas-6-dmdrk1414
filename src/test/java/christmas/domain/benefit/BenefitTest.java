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

class BenefitTest {
    private Benefit benefit;

    @BeforeEach
    void setUp() {
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);
    }

    @DisplayName("혜택 내역(할인, 경품)을 Map구조로 만드는 기능 추가")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1 ,1, 크리스마스 디데이 할인=1000, 주말 할인=4046, 샴페인=25000, 평일 할인=0, 특별 할인=0",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 3, 크리스마스 디데이 할인=1200, 주말 할인=0, 평일 할인=6069, 특별 할인=1000",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 4, 크리스마스 디데이 할인=1300, 주말 할인=0, 샴페인=25000, 평일 할인=2023, 특별 할인=0",
            "해산물파스타-1크리스마스파스타-1아이스크림-2샴페인-1, 5, 크리스마스 디데이 할인=1400, 주말 할인=0, 평일 할인=4046, 특별 할인=0",

    })
    void getInformation(String orderString, Integer orderDay, String target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders order = new Orders(orderString);
        benefit = new Benefit(orderDay, order);

        // when
        Map<String, Integer> result = benefit.getInformation();

        // then
        assertThat(result.toString()).contains(target);
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
    void getTotalBenefit(String orderString, Integer target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Integer result = benefit.getTotalBenefit();

        // than
        assertThat(result).isEqualTo(target);
    }

    @DisplayName("해택 액수에 따른 뱃지를 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 산타",
            "타파스-1제로콜라-1, 없음",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 별",
            "양송이수프-1타파스-1아이스크림-4제로콜라-2, 트리",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 산타",
    })
    void getBadgeName(String orderString, String target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        String result = benefit.getBadgeName();

        // than
        assertThat(result).contains(target);
    }

    @DisplayName("증정 메뉴을 확인한다")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 142000, {샴페인=1}",
            "타파스-1제로콜라-1, 8500, {}",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 93000, {}",
            "양송이수프-1타파스-1아이스크림-4제로콜라-2, 37500, {}",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 145000, {샴페인=1}",
    })
    void getFreebieMenu(String orderString, Integer orderMoney, String target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Map<String, Integer> result = benefit.getFreebieMenu(orderMoney);

        // than
        assertThat(result.toString()).contains(target);
    }
}