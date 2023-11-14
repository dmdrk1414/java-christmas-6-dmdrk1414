package christmas.domain.freebie;

import christmas.constant.freebie.Freebies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void isEligible() {
        // given


        // when


        // then

    }

    @Test
    void getPrice() {
        // given


        // when


        // then

    }
}