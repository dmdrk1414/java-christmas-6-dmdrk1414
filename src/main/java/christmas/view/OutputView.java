package christmas.view;

import christmas.constant.title.Title;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    private static final String NOTTING = "없음";
    private static final String UNIT_MONEY = "원";
    private static final String BLANK = " ";
    private static final String DASH = "-";
    private static final String UNIT_QUANTITY = "개";
    private static final String MONTH = "12월";

    public void printIntroduce() {
        println(Title.INTRODUCE.msg());
    }

    public void printEventPreview(Integer orderDate) {
        println(MONTH + BLANK + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        newLine();
    }

    public void printOrderMenu(Map<String, Integer> orders) {
        println(Title.ORDER_MENU.msg());

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();

            println(menu + BLANK + quantity + UNIT_QUANTITY);
        }
        newLine();
    }

    public void printOriginalOrderTotalAcount(Integer orderTotalAcount) {
        println(Title.ORIGINAL_ORDER_TOTAL_ACOUNT.msg());

        println(orderTotalAcount + UNIT_MONEY);
        newLine();
    }

    public void printFreebieMenu(Map<String, Integer> freebies) {
        println(Title.FREEBIE_MENU.msg());

        for (Map.Entry<String, Integer> entry : freebies.entrySet()) {
            String freebie = entry.getKey();
            Integer quantity = entry.getValue();

            println(freebie + BLANK + quantity + UNIT_QUANTITY);
        }

        notThingFreebies(freebies);
        newLine();
    }

    public void printBenefitInformations(Map<String, Integer> benefitInformations) {
        println(Title.BENEFIT_INFORMATION.msg());

        for (Map.Entry<String, Integer> entry : benefitInformations.entrySet()) {
            String title = entry.getKey();
            String discountMoney = formatNumberWithCommas(entry.getValue());

            println(title + ": -" + discountMoney + UNIT_MONEY);
        }

        notTingBenefitInformation(benefitInformations);
        newLine();
    }

    public void printTotalDiscount(Integer totalDiscount) {
        String totalDiscountString = formatNumberWithCommas(totalDiscount);

        println(Title.TOTAL_DISCOUNT.msg());
        if (totalDiscount == 0) {
            println(totalDiscountString + UNIT_MONEY);
        }
        if (totalDiscount != 0) {
            println(DASH + totalDiscountString + UNIT_MONEY);
        }
        newLine();
    }

    public void printFinalPayment(Integer finalPaymantMoney) {
        String finalPaymantMoneyString = formatNumberWithCommas(finalPaymantMoney);

        println(Title.FINAL_PAYMENT.msg());
        println(finalPaymantMoneyString + UNIT_MONEY);
        newLine();
    }

    public void printEventBadge(String badgeName) {
        println(Title.EVENT_BADGE.msg());

        println(badgeName);
    }

    private void notTingBenefitInformation(Map<String, Integer> benefitInformations) {
        if (benefitInformations.isEmpty()) {
            printNotThing();
        }
    }

    private String formatNumberWithCommas(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        return numberFormat.format(number);
    }

    private void printNotThing() {
        println(NOTTING);
    }

    private void println(String string) {
        System.out.println(string);
    }

    private void newLine() {
        System.out.println();
    }

    private void notThingFreebies(Map<String, Integer> freebies) {
        if (freebies.isEmpty()) {
            printNotThing();
        }
    }
}
