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

    @Disabled
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

    @Disabled
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
