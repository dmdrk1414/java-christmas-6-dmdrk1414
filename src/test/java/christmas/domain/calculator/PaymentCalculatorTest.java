package christmas.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculatorTest {

    @Test
    void 할인후_주문_예산_결제_금액을_확인한다() {
        // given
        Integer totalOrderMoney = 20_000;
        Integer discount = 2_000;
        PaymentCalculator paymentCalculator = new PaymentCalculator();

        // when
        Integer result = paymentCalculator.estimateFinalPayment(totalOrderMoney, discount);

        // then
        assertThat(result).isEqualTo(18_000);
    }
}