package christmas.domain.freebie;

import christmas.constant.freebie.Freebies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChampagneTest {
    private Champagne champagne;

    @BeforeEach
    void setUp() {
        champagne = new Champagne();
    }

    @DisplayName("샴페인의 정보를 Map형태로 확인한다")
    @Test
    void makeChampagneCountInformation() {
        // given
        Map<String, Integer> target = new HashMap<>();
        target.put(Freebies.CHAMPAGNE.getName(), Freebies.CHAMPAGNE.getCount());

        // when
        Map<String, Integer> result = champagne.makeChampagneCountInformation();

        // then
        assertThat(result).isEqualTo(target);
    }

    @DisplayName("샴페인의 증정받을 수 있는지 확인한다")
    @ParameterizedTest
    @CsvSource({
            "10_000, false",
            "100_000, false",
            "120_000, true",
            "220_000, true",
    })
    void isEligible(Integer orderMoney, Boolean target) {
        // when
        Boolean result = champagne.isEligible(orderMoney);

        // then
        assertThat(result).isEqualTo(target);
    }

    @DisplayName("증정품 샴페인의 가격을 확인한다.")
    @Test
    void getPrice() {
        // given
        Integer target = Freebies.CHAMPAGNE.getPrice();

        // when
        Integer result = champagne.getPrice();

        // then
        assertThat(result).isEqualTo(target);
    }
}