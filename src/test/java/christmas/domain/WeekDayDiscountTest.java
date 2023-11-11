package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeekDayDiscountTest {

    @DisplayName("주문 날짜에 따른 평일 할인 해택 금액을 알려주는 기능")
    @ParameterizedTest
    @CsvSource({
            "3, 2023",
            "4, 2023",
            "5, 2023",
            "6, 2023",
            "7, 2023",

            "10, 2023",
            "11, 2023",
            "12, 2023",
            "13, 2023",
            "14, 2023",

            "17, 2023",
            "18, 2023",
            "19, 2023",
            "20, 2023",
            "21, 2023",

            "24, 2023",
            "25, 2023",
            "26, 2023",
            "27, 2023",
            "28, 2023",

            "31, 2023"
    })
    void giveAmount(Integer orderDay, Integer amount) {
        WeekDayDiscount weekDayDiscount = new WeekDayDiscount(orderDay);
        // when
        Integer result = weekDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @DisplayName("해당 주문 날짜기 평일 할인 행사인지 확인하는 기능 ")
    @ParameterizedTest
    @CsvSource({
            //평일
            "3, true",
            "4, true",
            "5, true",
            "6, true",
            "7, true",

            "10, true",
            "11, true",
            "12, true",
            "13, true",
            "14, true",

            "17, true",
            "18, true",
            "19, true",
            "20, true",
            "21, true",

            "24, true",
            "25, true",
            "26, true",
            "27, true",
            "28, true",

            "31, true",

            // 주말
            "1, false",
            "2, false",
            "8, false",
            "9, false",
            "15, false",
            "16, false",
            "22, false",
            "23, false",
            "29, false",
            "30, false",
    })
    void checkPeriod(Integer orderDay, Boolean confirm) {
        // given
        WeekDayDiscount weekDayDiscount = new WeekDayDiscount(orderDay);

        // when
        Boolean result = weekDayDiscount.checkPeriod();

        // than
        assertThat(result).isEqualTo(confirm);
    }
}