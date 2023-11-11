package christmas.domain.freebie;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FreebieTest {
    private Freebie freebie;

    @Test
    void getFreebie() {
        freebie = new Freebie();
    }

    @Test
    void isEligible() {
    }

    @DisplayName("증정품의 정보를 얻는 기능")
    void getInformations() {
        // given
        Map<String, Integer> target = new HashMap<>();
        target.put(Menu.CHAMPAGNE.getName(), Menu.CHAMPAGNE.getPrice());

        // when
        Map<String, Integer> result = freebie.getInformations();

        // then
        assertThat(result).isEqualTo(target);
    }
}