package christmas.domain.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDayDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "3, 1000",
            "10, 1000",
            "17, 1000",
            "24, 1000",
            "25, 1000",
            "31, 1000"
    })
    void 주문_날짜에_따른_특별_할인_해택_금액을_확인한다(Integer orderDay, Integer amount) {
        // given
        SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(orderDay);
        // when
        Integer result = specialDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource({
            "3",
            "10",
            "17",
            "24",
            "25",
            "31"
    })
    void 특별_할인의_제목을_확인한다(Integer orderDay) {
        // given
        SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(orderDay);

        // when
        String result = specialDayDiscount.giveTitle();

        // then
        assertThat(result).contains("특별 할인");
    }
}

