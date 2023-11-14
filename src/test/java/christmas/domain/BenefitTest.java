package christmas.domain;

import christmas.domain.benefit.Benefit;
import christmas.domain.order.Orders;
import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BenefitTest {
    private Benefit benefit;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("혜택 내역(할인, 경품)을 Map구조로 만드는 기능 추가")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1 ,1, 크리스마스 디데이 할인=1000, 주말 할인=4046, 샴페인=25000, 평일 할인=0, 특별 할인=0",
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
        Map<String, Integer> result = benefit.getInformation();

        // then
        assertThat(result.toString()).contains(target);
    }

//    @DisplayName("샴페인 증정 상품을 얻을 수 있는 지 확인하는 기능 테스트")
//    @ParameterizedTest
//    @CsvSource({
//            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, true",
//            "타파스-1제로콜라-1, false",
//            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, false",
//            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, true",
//            "해산물파스타-1크리스마스파스타-1아이스크림-2샴페인-1, false",
//            "양송이수프-1티본스테이크-2아이스크림-2샴페인-1, true",
//            "타파스-1크리스마스파스타-1아이스크림-3제로콜라-2, false",
//            "시저샐러드-2바비큐립-1초코케이크-2제로콜라-1, false",
//            "양송이수프-1바비큐립-1해산물파스타-2샴페인-1, true",
//            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
//            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, false",
//            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, false",
//            "시저샐러드-2바비큐립-1아이스크림-3샴페인-2, true",
//            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, false",
//            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
//            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, false",
//            "양송이수프-1바비큐립-1초코케이크-2샴페인-1, false",
//            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
//            "시저샐러드-2크리스마스파스타-1아이스크림-2샴페인-1, false"
//    })
//    void isEligibleFreebie(String orderString, Boolean target) {
//        // given
//        orderString = TestUtill.insertComma(orderString);
//        Orders order = new Orders(orderString);
//        Benefit benefit = new Benefit(1, order);
//
//        // when
//        Boolean result = benefit.isEligibleFreebie();
//
//        // then
//        assertThat(result).isEqualTo(target);
//    }

//    @DisplayName("해택의 전체의 액수를 알수있는 테스트")
//    @ParameterizedTest
//    @CsvSource({
//            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 31246",
//            "타파스-1제로콜라-1, 0",
//            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 8269",
//            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 29223",
//    })
//    void getTotalAmount(String orderString, Integer target) {
//        // given
//        orderString = TestUtill.insertComma(orderString);
//        Orders order = new Orders(orderString);
//        Benefit benefit = new Benefit(3, order);
//
//        // when
//        Integer result = benefit.getTotalAmount();
//
//        // than
//        assertThat(result).isEqualTo(target);
//    }

    @DisplayName("해택에 따른 뱃지를 알수있는 테스트")
    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 산타",
            "타파스-1제로콜라-1, 없음",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 별",
            "양송이수프-1타파스-1아이스크림-4제로콜라-2, 트리",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 산타",
    })
    void getBadgeName(String orderString, String target) {
        orderString = TestUtill.insertComma(orderString);
        Orders order = new Orders(orderString);
        Benefit benefit = new Benefit(3, order);

        // when
        String result = benefit.getBadgeName();

        // than
        assertThat(result).isEqualTo(target);
    }
}