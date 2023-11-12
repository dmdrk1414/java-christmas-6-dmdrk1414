package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeManagementTest {

    @DisplayName("가격에 따른 뱃지 할당하는 기능")
    @ParameterizedTest
    @CsvSource({
            "1000, 없음",
            "5000, 별",
            "10000, 트리",
            "15000, 트리",
            "20000, 산타",
            "100000, 산타",
    })
    void getBadge(Integer totalDiscount, String badgeName) {
        // given
        BadgeManagement badgeManagement = new BadgeManagement();

        // when
        String result = badgeManagement.getBadge(totalDiscount);

        // then
        assertThat(result).isEqualTo(badgeName);
    }

}