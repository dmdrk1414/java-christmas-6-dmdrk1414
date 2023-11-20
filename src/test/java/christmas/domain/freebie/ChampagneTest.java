package christmas.domain.freebie;

import christmas.constant.freebie.Freebies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ChampagneTest {
    private Champagne champagne;

    @BeforeEach
    void setUp() {
        champagne = new Champagne();
    }

    @Test
    void 증점품_샴페인의_이름_갯수_정보를_확인한다() {
        // given
        Map<String, Integer> target = new HashMap<>();
        target.put(Freebies.CHAMPAGNE.getName(), Freebies.CHAMPAGNE.getCount());

        // when
        Map<String, Integer> result = champagne.makeChampagneCountInformation();

        // then
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @CsvSource({
            "10_000, false",
            "100_000, false",
            "120_000, true",
            "220_000, true",
    })
    void 증정품_샴페인을_증점받을_수_있는지_확인한다(Integer orderMoney, Boolean target) {
        // when
        Boolean result = champagne.isEligible(orderMoney);

        // then
        assertThat(result).isEqualTo(target);
    }

    @Test
    void 증정품_샴페인의_가격을_확인한다() {
        // given
        Integer target = Freebies.CHAMPAGNE.getPrice();

        // when
        Integer result = champagne.getPrice();

        // then
        assertThat(result).isEqualTo(target);
    }
}