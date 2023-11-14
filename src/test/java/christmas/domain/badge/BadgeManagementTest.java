package christmas.domain.badge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeManagementTest {

    @DisplayName("해택 금액에 따른 벳지결과 확인")
    @ParameterizedTest
    @CsvSource({
            "0, 없음",
            "3000, 없음",
            "5000, 별",
            "8000, 별",
            "10000, 트리",
            "15000, 트리",
            "20000, 산타",
            "30000, 산타",

    })
    void getBadge(Integer benefit, String badge) {
        // given
        BadgeManagement badgeManagement = new BadgeManagement();

        // when
        String result = badgeManagement.getBadge(benefit);

        // than
        assertThat(result).contains(badge);
    }
}