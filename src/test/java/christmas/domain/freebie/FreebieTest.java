package christmas.domain.freebie;

import christmas.constant.freebie.Freebies;
import christmas.domain.order.Orders;
import christmas.domain.testutill.TestUtill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FreebieTest {
    private static final String FREEBIE_TITLE = "증정 이벤트";
    private static final Integer FREEBIE_PRICE = 25_000;
    private static final Integer FREEBIE_COUNT = 1;
    private static final String CHAMPANE = Freebies.CHAMPAGNE.getName();
    private Freebie freebie;

    @BeforeEach
    void setUp() {
        freebie = new Freebie();
    }

    @Test
    void getFreebie() {
    }

    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, true",
            "타파스-1제로콜라-1, false",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, false",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, true",
            "해산물파스타-1크리스마스파스타-1아이스크림-2샴페인-1, false",
            "양송이수프-1티본스테이크-2아이스크림-2샴페인-1, true",
            "타파스-1크리스마스파스타-1아이스크림-3제로콜라-2, false",
            "시저샐러드-2바비큐립-1초코케이크-2제로콜라-1, false",
            "양송이수프-1바비큐립-1해산물파스타-2샴페인-1, true",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, false",
            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, false",
            "시저샐러드-2바비큐립-1아이스크림-3샴페인-2, true",
            "양송이수프-1크리스마스파스타-1초코케이크-2샴페인-1, false",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
            "시저샐러드-2크리스마스파스타-1아이스크림-2레드와인-1, false",
            "양송이수프-1바비큐립-1초코케이크-2샴페인-1, false",
            "양송이수프-1바비큐립-1초코케이크-1레드와인-1, true",
            "시저샐러드-2크리스마스파스타-1아이스크림-2샴페인-1, false"
    })
    void 증정_상품중_샴페인을_얻을_수_있는지_확인한다(String orderString, Boolean target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders order = new Orders(orderString);

        // when
        Boolean result = freebie.isEligibleChampagne(order.getOrderMoney());

        // then
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {120_000, 200_000, 300_000})
    void 주문금액이_12만원_이상일때_증정품의_정보_알려준다(Integer orderMoney) {
        // given
        Map<String, Integer> target = new HashMap<>();
        target.put(FREEBIE_TITLE, FREEBIE_PRICE);

        // when
        Map<String, Integer> result = freebie.getPriceInformation(orderMoney);

        // than
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000, 100_000, 0})
    void 주문금액이_12만원_미만일때_증정품의_정보_알려준다(Integer orderMoney) {
        // when
        Map<String, Integer> result = freebie.getPriceInformation(orderMoney);

        // than
        assertThat(result).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "티본스테이크-1바비큐립-1초코케이크-2제로콜라-1, 25000",
            "타파스-1제로콜라-1, 0",
            "양송이수프-1타파스-2티본스테이크-1아이스크림-3제로콜라-2, 0",
            "시저샐러드-2바비큐립-1초코케이크-1레드와인-1, 25000",
    })
    void 증정품_샴페인의_가격을_확인한다(String orderString, Integer target) {
        // given
        orderString = TestUtill.insertComma(orderString);
        Orders order = new Orders(orderString);

        // when
        Integer result = freebie.getChampagneBenefit(order.getOrderMoney());

        // than
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {120_000, 200_000, 300_000})
    void 주문금액이_12만원_이상일때_증정품의_메뉴를_확인한다(Integer orderMoney) {
        // given
        Map<String, Integer> target = new HashMap<>();
        target.put(CHAMPANE, FREEBIE_COUNT);

        // when
        Map<String, Integer> result = freebie.getFreebieMenu(orderMoney);

        // than
        assertThat(result).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000, 100_000, 0})
    void 주문금액이_12만원_미만일때_증정품의_메뉴를_알려준다(Integer orderMoney) {
        // when
        Map<String, Integer> result = freebie.getFreebieMenu(orderMoney);

        // than
        assertThat(result).isEmpty();
    }
}