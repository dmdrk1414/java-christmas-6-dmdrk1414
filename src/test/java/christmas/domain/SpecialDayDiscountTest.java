package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpecialDayDiscountTest {

    @DisplayName("주문 날짜에 따른 평일 할인 해택 금액을 알려주는 기능")
    @ParameterizedTest
    @CsvSource({
            "3, 2023",
            "10, 2023",
            "17, 2023",
            "24, 2023",
            "25, 2023",
            "31, 2023"
    })
    void giveAmount(Integer orderDay, Integer amount) {
        // given
        SpecialDayDiscount specialDayDiscount = new SpecialDayDiscount(orderDay);
        // when
        Integer result = specialDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }
}