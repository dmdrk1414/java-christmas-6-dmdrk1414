package christmas.domain.discount;

import christmas.domain.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountManagementTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("주문날짜의 총 할인 금액을 얻는 기능 구현_주말")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 2, 5046",
            "2, 2, 2, 5146",

            "8, 2, 2, 5746",
            "9, 2, 2, 5846",

            "15, 2, 2, 6446",
            "16, 2, 2, 6546",

            "22, 2, 2, 7146",
            "23, 2, 2, 7246",

            "29, 2, 2, 4046",
            "30, 2, 2, 4046",
    })
    void getTotalDiscount_주말(Integer orderDay, Integer mainCount, Integer dessertCount, Integer totalDiscount) {
        // given
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(inputString);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, orders);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }

    @DisplayName("주문날짜의 총 할인 금액을 얻는 기능 구현_평일")
    @ParameterizedTest
    @CsvSource({
            "3, 2, 2, 6246",
            "4, 2, 2, 5346",
            "5, 2, 2, 5446",
            "6, 2, 2, 5546",
            "7, 2, 2, 5646",

            "10, 2, 2, 6946",
            "11, 2, 2, 6046",
            "12, 2, 2, 6146",
            "13, 2, 2, 6246",
            "14, 2, 2, 6346",

            "17, 2, 2, 7646",
            "18, 2, 2, 6746",
            "19, 2, 2, 6846",
            "20, 2, 2, 6946",
            "21, 2, 2, 7046",

            "24, 2, 2, 8346",
            "25, 2, 2, 8446",
            "26, 2, 2, 4046",
            "27, 2, 2, 4046",
            "28, 2, 2, 4046",

            "31, 2, 2, 5046",
    })
    void getTotalDiscount_평일(Integer orderDay, Integer mainCount, Integer dessertCount, Integer totalDiscount) {
        // given
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(inputString);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, orders);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }

    @DisplayName("주문날짜의 총 할인 금액을 얻는 기능 구현_특별")
    @ParameterizedTest
    @CsvSource({
            "3, 2, 2, 6246",
            "10, 2, 2, 6946",
            "17, 2, 2, 7646",
            "24, 2, 2, 8346",
            "25, 2, 2, 8446",
            "31, 2, 2, 5046",
    })
    void getTotalDiscount_특별(Integer orderDay, Integer mainCount, Integer dessertCount, Integer totalDiscount) {
        // given
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(inputString);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, orders);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }

    @DisplayName("할인 내역을 Map구조로 만드는 기능 테스트")
    @Test
    void getInformations() {
        // given
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(inputString);
        DiscountManagement discountManagement = new DiscountManagement(3, orders);

        Map<String, Integer> target = new HashMap<>();
        target.put("크리스마스 디데이 할인", 1200);
        target.put("주말 할인", 0);
        target.put("평일 할인", 4046);
        target.put("특별 할인", 1000);

        // when
        Map<String, Integer> result = discountManagement.getInformations();
        System.out.println("result = " + result);

        // then
        assertThat(result).isEqualTo(target);
    }

    @DisplayName("할인 내역을 Map구조로 만드는 기능 테스트_2")
    @Test
    void getInformations_2() {
//        result = {크리스마스 디데이 할인=1000, 주말 할인=4046, 평일 할인=0, 특별 할인=0}
        // given
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(inputString);
        DiscountManagement discountManagement = new DiscountManagement(1, orders);

        Map<String, Integer> target = new HashMap<>();
        target.put("크리스마스 디데이 할인", 1000);
        target.put("주말 할인", 4046);
        target.put("평일 할인", 0);
        target.put("특별 할인", 0);

        // when
        Map<String, Integer> result = discountManagement.getInformations();
        System.out.println("result = " + result);

        // then
        assertThat(result).isEqualTo(target);
    }
}