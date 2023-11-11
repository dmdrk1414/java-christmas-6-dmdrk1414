package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        WeekendDayDiscount weekendDayDiscount = new WeekendDayDiscount(orderDay);
        // when
        Integer result = weekendDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }
}