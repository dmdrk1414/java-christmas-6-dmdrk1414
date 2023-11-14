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
}

