package christmas.domain;

import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BenefitTest {
    private Benefit benefit;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("혜택 내역(할인, 경품)을 Map구조로 만드는 기능 추가")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1 ,1, 크리스마스 디데이 할인=1000, 주말 할인=4046, 샴페인=25000, 평일 할인=0, 특별 할인=0",
            "타파스-1제로콜라-1 ,2, 크리스마스 디데이 할인=0, 주말 할인=0, 평일 할인=0, 특별 할인=0",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 3, 크리스마스 디데이 할인=1200, 주말 할인=0, 평일 할인=6069, 특별 할인=1000",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 4, 크리스마스 디데이 할인=1300, 주말 할인=0, 샴페인=25000, 평일 할인=2023, 특별 할인=0",
            "해산물파스타-1크리스마스파스타-1아이스크림-2샴페인-1, 5, 크리스마스 디데이 할인=1400, 주말 할인=0, 평일 할인=4046, 특별 할인=0",

    })
    void generateInformations(String orderString, Integer orderDay, String target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders order = new Orders(orderString);
        benefit = new Benefit(orderDay, order);

        // when
        Map<String, Integer> result = benefit.generateInformations();

        // then
        assertThat(result.toString()).contains(target);
    }
}