package christmas.domain.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekDayDiscountTest {
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
    void 주문_날짜에_따른_평일_할인_혜택_금액을_확인한다(Integer orderDay, Integer amount) {
        Integer desserdCount = 3;
        amount = amount * desserdCount;
        WeekDayDiscount weekDayDiscount = new WeekDayDiscount(orderDay, desserdCount);
        // when
        Integer result = weekDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource({
            "3", "4", "5", "6", "7",
            "10", "11", "12", "13", "14",
            "17", "18", "19", "20", "21",
            "24", "25", "26", "27", "28",
            "31"
    })
    void 평일_할인의_제목을_확인한다(Integer orderDay) {
        // given
        Integer desserdCount = 3;
        WeekDayDiscount weekDayDiscount = new WeekDayDiscount(orderDay, desserdCount);

        // when
        String result = weekDayDiscount.giveTitle();

        // then
        assertThat(result).contains("평일 할인");
    }
}