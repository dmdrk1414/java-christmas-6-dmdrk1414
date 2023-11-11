package christmas.domain.disconunt;

import christmas.domain.discount.SpecialDayDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDayDiscountTest {

    @DisplayName("주문 날짜에 따른 특별 할인 해택 금액을 알려주는 기능 테스트")
    @ParameterizedTest
    @CsvSource({
            "3, 1000",
            "10, 1000",
            "17, 1000",
            "24, 1000",
            "25, 1000",
            "31, 1000"
    })
    void giveAmount(Integer orderDay, Integer amount) {
        // given
        SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(orderDay);
        // when
        Integer result = specialDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @DisplayName("주문 날짜에 따른 특별 할인 해택 가능 날짜 확인 기능 추가")
    @ParameterizedTest
    @CsvSource({
            // 가능
            "3, true",
            "10, true",
            "17, true",
            "24, true",
            "25, true",
            "31, true",

            // 불가능
            "1, false",
            "2, false",
            "4, false",
            "5, false",
            "6, false",
            "7, false",
            "8, false",
            "9, false",
            "11, false",
            "12, false",
            "13, false",
            "14, false",
            "15, false",
            "16, false",
            "18, false",
            "19, false",
            "20, false",
            "21, false",
            "22, false",
            "23, false",
            "26, false",
            "27, false",
            "28, false",
            "29, false",
            "30, false",
    })
    void checkPeriod(Integer orderDay, Boolean confirm) {
        // given
        SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(orderDay);

        // when
        Boolean result = specialDayDiscount.checkPeriod();

        // than
        assertThat(result).isEqualTo(confirm);
    }
}