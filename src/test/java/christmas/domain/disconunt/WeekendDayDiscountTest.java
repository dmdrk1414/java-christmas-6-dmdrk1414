package christmas.domain.disconunt;

import christmas.domain.discount.WeekendDayDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDayDiscountTest {

    @DisplayName("해당 주문 날짜기 디데이 할인 행사인지 확인하는 기능 ")
    @ParameterizedTest
    @CsvSource({
            "1, 2023",
            "2, 2023",

            "8, 2023",
            "9, 2023",

            "15, 2023",
            "16, 2023",

            "22, 2023",
            "23, 2023",

            "29, 2023",
            "30, 2023",
    })
    void giveAmount(Integer orderDay, Integer amount) {
        // given
        Integer mainCount = 1;
        amount = amount * mainCount;
        WeekendDayDiscount weekendDayDiscount = new WeekendDayDiscount(orderDay, mainCount);
        // when
        Integer result = weekendDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @DisplayName("해당 주문 날짜가 주말 할인 행사인지 확인하는 기능 ")
    @ParameterizedTest
    @CsvSource({
            // 주말
            "1, true",
            "2, true",

            "8, true",
            "9, true",

            "15, true",
            "16, true",

            "22, true",
            "23, true",

            "29, true",
            "30, true",

            // 평일
            "3, false",
            "4, false",
            "5, false",
            "6, false",
            "7, false",

            "10, false",
            "11, false",
            "12, false",
            "13, false",
            "14, false",

            "17, false",
            "18, false",
            "19, false",
            "20, false",
            "21, false",

            "24, false",
            "25, false",
            "26, false",
            "27, false",
            "28, false",

            "31, false",
    })
    void checkPeriod(Integer orderDay, Boolean confirm) {
        // given
        Integer mainCount = 1;
        WeekendDayDiscount weekendDayDiscount = new WeekendDayDiscount(orderDay, mainCount);

        // when
        Boolean result = weekendDayDiscount.checkPeriod();

        // than
        assertThat(result).isEqualTo(confirm);
    }
}