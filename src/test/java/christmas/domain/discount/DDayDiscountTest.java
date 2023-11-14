package christmas.domain.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DDayDiscountTest {
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
    void 주문_날짜에_의한_디데이_행사의_여부확인(Integer orderDay, Integer amount) {
        // given
        DDayDiscount dDayDiscount = new DDayDiscount(orderDay);
        // when
        Integer result = dDayDiscount.giveAmount();

        // then
        assertThat(result).isEqualTo(amount);
    }
}