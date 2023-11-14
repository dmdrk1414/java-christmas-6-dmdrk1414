package christmas.domain.discount;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountManagementTest {
    private Orders orders;

    @BeforeEach
    void setUp() {
        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        orders = new Orders(inputString);
    }

    @DisplayName("주문날짜의 총 할인 금액을 얻는 기능 구현_디데이_주말")
    @ParameterizedTest
    @CsvSource({
            "1, 5046",
            "2, 5146",

            "8, 5746",
            "9, 5846",

            "15, 6446",
            "16, 6546",

            "22, 7146",
            "23, 7246",

            "29, 4046",
            "30, 4046",
    })
    void getTotalDiscount_디데이_주말(Integer orderDay, Integer totalDiscount) {
        // given

        DiscountManagement discountManagement = new DiscountManagement(orderDay, orders);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }

    @DisplayName("주문날짜의 총 할인 금액을 얻는 기능 구현_디데이_평일")
    @ParameterizedTest
    @CsvSource({
            "3, 6246",
            "4, 5346",
            "5, 5446",
            "6, 5546",
            "7, 5646",

            "10, 6946",
            "11, 6046",
            "12, 6146",
            "13, 6246",
            "14, 6346",

            "17, 7646",
            "18, 6746",
            "19, 6846",
            "20, 6946",
            "21, 7046",

            "24, 8346",
            "25, 8446",
            "26, 4046",
            "27, 4046",
            "28, 4046",

            "31, 5046",
    })
    void getTotalDiscount_디데이_평일(Integer orderDay, Integer totalDiscount) {
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
            "3, 6246",
            "10, 6946",
            "17, 7646",
            "24, 8346",
            "25, 8446",
            "31, 5046",
    })
    void getTotalDiscount_특별(Integer orderDay, Integer totalDiscount) {
        // given
        DiscountManagement discountManagement = new DiscountManagement(orderDay, orders);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }

//    @DisplayName("할인 내역을 Map구조로 만드는 기능 테스트")
//    @Test
//    void getInformations() {
//        // given
//        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
//        Orders orders = new Orders(inputString);
//        DiscountManagement discountManagement = new DiscountManagement(3, orders);
//
//        Map<String, Integer> target = new HashMap<>();
//        target.put("크리스마스 디데이 할인", 1200);
//        target.put("주말 할인", 0);
//        target.put("평일 할인", 4046);
//        target.put("특별 할인", 1000);
//
//        // when
//        Map<String, Integer> result = discountManagement.getInformations();
//        System.out.println("result = " + result);
//
//        // then
//        assertThat(result).isEqualTo(target);
//    }
//
//    @DisplayName("할인 내역을 Map구조로 만드는 기능 테스트_2")
//    @Test
//    void getInformations_2() {
////        result = {크리스마스 디데이 할인=1000, 주말 할인=4046, 평일 할인=0, 특별 할인=0}
//        // given
//        String inputString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
//        Orders orders = new Orders(inputString);
//        DiscountManagement discountManagement = new DiscountManagement(1, orders);
//
//        Map<String, Integer> target = new HashMap<>();
//        target.put("크리스마스 디데이 할인", 1000);
//        target.put("주말 할인", 4046);
//        target.put("평일 할인", 0);
//        target.put("특별 할인", 0);
//
//        // when
//        Map<String, Integer> result = discountManagement.getInformations();
//        System.out.println("result = " + result);
//
//        // then
//        assertThat(result).isEqualTo(target);
//    }
}