package christmas.domain.disconunt;

import christmas.domain.discount.DDayDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DDayDiscountTest {
    private DDayDiscount dDayDiscount;

    @BeforeEach
    void setUp() {
        dDayDiscount = new DDayDiscount(1);
    }

    @DisplayName("주문 날짜에 따른 디데이 행사의 여부와 가격 알기.")
    @ParameterizedTest
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "3, 1200",
            "4, 1300",
            "5, 1400",
            "6, 1500",
            "7, 1600",
            "8, 1700",
            "9, 1800",
            "10, 1900",
            "11, 2000",
            "12, 2100",
            "13, 2200",
            "14, 2300",
            "15, 2400",
            "16, 2500",
            "17, 2600",
            "18, 2700",
            "19, 2800",
            "20, 2900",
            "21, 3000",
            "22, 3100",
            "23, 3200",
            "24, 3300",
            "25, 3400"
    })
    void giveAmount(Integer orderDay, Integer amount) {
        // given
        DDayDiscount dDayDiscount = new DDayDiscount(orderDay);
        // when
        Integer result = dDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @DisplayName("해당 주문 날짜기 디데이 할인 행사인지 확인하는 기능 ")
    @ParameterizedTest
    @CsvSource({
            // 디데이 가능
            "1, true",
            "2, true",
            "3, true",
            "4, true",
            "5, true",
            "6, true",
            "7, true",
            "8, true",
            "9, true",
            "10, true",
            "11, true",
            "12, true",
            "13, true",
            "14, true",
            "15, true",
            "16, true",
            "17, true",
            "18, true",
            "19, true",
            "20, true",
            "21, true",
            "22, true",
            "23, true",
            "24, true",
            "25, true",

            // 불가능
            "26, false",
            "27, false",
            "28, false",
            "29, false",
            "30, false",
            "31, false",
    })
    void checkPeriod(Integer orderDay, Boolean confirm) {
        // given
        dDayDiscount = new DDayDiscount(orderDay);

        // when
        Boolean result = dDayDiscount.checkPeriod();

        // than
        assertThat(result).isEqualTo(confirm);
    }
}