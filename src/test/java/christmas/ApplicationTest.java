package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "<할인 전 총주문 금액>",
                    "<증정 메뉴>",
                    "<혜택 내역>",
                    "<총혜택 금액>",
                    "<할인 후 예상 결제 금액>",
                    "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 모든_타이틀_출력_2() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "티본스테이크 1개",
                    "제로콜라 1개",
                    "초코케이크 2개",
                    "바비큐립 1개",
                    "<할인 전 총주문 금액>",
                    "142000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "<총혜택 금액>",
                    "-31,246원",
                    "<할인 후 예상 결제 금액>",
                    "135,754원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }

    @Test
    void 모든_타이틀_출력_3() {
        assertSimpleTest(() -> {
            run("3", "타파스-1,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "타파스 1개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>",
                    "8,500원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "없음",
                    "<총혜택 금액>",
                    "0원",
                    "<할인 후 예상 결제 금액>",
                    "8,500원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

    @Test
    void 모든_타이틀_출력_총주문_10000원_미만() {
        assertSimpleTest(() -> {
            run("3", "아이스크림-1,제로콜라-1");
            assertThat(output()).contains(
                    "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.",
                    "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
                    "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)",
                    "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
                    "<주문 메뉴>",
                    "<할인 전 총주문 금액>",
                    "<증정 메뉴>",
                    "<혜택 내역>",
                    "<총혜택 금액>",
                    "<할인 후 예상 결제 금액>",
                    "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @CsvSource({"0,32,100"})
    void 날짜_예외_테스트_범위를_넘어선_숫자입력_테스트(String num1, String num2, String num3) {
        assertSimpleTest(() -> {
            runException(num1, num2, num3);
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트_공백포함_테스트() {
        assertSimpleTest(() -> {
            runException("1 3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "1a", "1박", "박승", "!2", "q!1", "@#$", "박&*("})
    void 날짜_예외_테스트_문자열_테스트(String orderDate) {
        assertSimpleTest(() -> {
            runException(orderDate);
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,,초코케이크-2,제로콜라-1",
    })
    void 주문_예외_테스트_COMMA_사이에_입력을_안한지_테스트(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1, 초코케이크-2,제로콜라-1",
            "티본스테이크-1,초코케이크-2, 제로콜라-1",
    })
    void 주문_예외_테스트_공백토함(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            ",티본스테이크-1,초코케이크-2,제로콜라-1,",
            "티본스테이크-1,초코케이크-2,제로콜라-1,",
            ",티본스테이크-1,초코케이크-2,제로콜라-1",
    })
    void 주문_예외_테스트_맨앞_뒤_COMMA_있을때_확인(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "TBON-1,초코케이크-2,제로콜라-1",
            "티본스테이크-TVON,초코케이크-2,제로콜라-1",
            "티본스테이크-티본,초코케이크-2,제로콜라-1",
            "티본스테이크-1,초코케이크2,제로콜라-1",
            "티본스테이크-1,초코케이크-2,제로콜라1",
            "티본스테이크-1,!@#-2,제로콜라-1",
            "!@#!@#-1,초코케이크-2,제로콜라-1",
    })
    void 주문_예외_테스트_주문_대쉬_앞문자_뒤숫자_검사(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-1,초코케이크-2,제로콜라-0",
            "티본스테이크-0,초코케이크-2,제로콜라-1",
            "티본스테이크-1,초코케이크-0,제로콜라-1",
            "티본스테이크-0,초코케이크-0,제로콜라-1",
            "티본스테이크-1,초코케이크-0,제로콜라-0",
            "티본스테이크-0,초코케이크-1,제로콜라-0",

    })
    void 주문_예외_테스트_주문_갯수_1이상_확인(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "제로콜라-1,샴페인-1",
            "제로콜라-1,레드와인-1",
            "레드와인-1,샴페인-1",
            "제로콜라-1",
            "레드와인-1",
            "샴페인-1",
    })
    void 주문_예외_테스트_오직_음료수만_있는지_확인(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "짜장면-1,초코케이크-2,제로콜라-1",
            "티본스테이크-1,짜장면-2,제로콜라-1",
            "티본스테이크-1,초코케이크-2,짜장면-1",
    })
    void 주문_예외_테스트_존제하지_않은_메뉴(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-1,시저샐러드-1",
            "시저샐러드-1,시저샐러드-2",
            "티본스테이크-1,티본스테이크-1,초코케이크-2,제로콜라-1",
    })
    void 주문_예외_테스트_중복_메뉴_주문(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-5,티본스테이크-5,크리스마스파스타-5,제로콜라-5,아이스크림-1",
            "시저샐러드-5,티본스테이크-5,크리스마스파스타-5,제로콜라-5,아이스크림-2",
    })
    void 주문_예외_테스트_메뉴_주문_최대_20개(String orderString) {
        assertSimpleTest(() -> {
            runException("1", orderString);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
