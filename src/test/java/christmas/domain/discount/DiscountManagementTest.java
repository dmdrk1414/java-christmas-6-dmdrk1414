package christmas.domain.discount;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        Order order = new Order(0, mainCount, dessertCount, 0);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, order);

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
        Order order = new Order(0, mainCount, dessertCount, 0);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, order);

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
        Order order = new Order(0, mainCount, dessertCount, 0);
        DiscountManagement discountManagement = new DiscountManagement(orderDay, order);

        // when
        Integer result = discountManagement.getTotalDiscount();

        // then
        assertThat(result).isEqualTo(totalDiscount);
    }
}