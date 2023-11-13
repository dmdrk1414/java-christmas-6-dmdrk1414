package christmas.domain.calculator;

public class PaymentCalculator {
    public Integer estimateFinalPayment(Integer totalOrderMoney, Integer totalDiscount) {
        return totalOrderMoney - totalDiscount;
    }
}
