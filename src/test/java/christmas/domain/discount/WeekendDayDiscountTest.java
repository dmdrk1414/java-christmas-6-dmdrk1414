package christmas.domain.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDayDiscountTest {
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
    void 주문_날짜에_따른_주말_할인_혜택_금액을_확인한다(Integer orderDay, Integer amount) {
        // given
        Integer mainCount = 1;
        amount = amount * mainCount;
        WeekendDayDiscount weekendDayDiscount = new WeekendDayDiscount(orderDay, mainCount);
        // when
        Integer result = weekendDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }


    @ParameterizedTest
    @CsvSource({
            "1", "2",
            "8", "9",
            "15", "16",
            "22", "23",
            "29", "30",
    })
    void 주말_할인의_제목을_확인한다(Integer orderDay) {
        // given
        Integer mainCount = 1;
        WeekendDayDiscount weekendDayDiscount = new WeekendDayDiscount(orderDay, mainCount);

        // when
        String result = weekendDayDiscount.giveTitle();

        // then
        assertThat(result).contains("주말 할인");
    }
}