package christmas.view;

import christmas.constant.title.Title;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    public void printIntroduce() {
        println(Title.INTRODUCE.msg());
    }

    public void printEventPreview(Integer orderDate) {
        println("12월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        newLine();
    }

    public void printOrderMenu(Map<String, Integer> orders) {
        println(Title.ORDER_MENU.msg());

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();

            println(menu + " " + quantity + "개");
        }
        newLine();
    }

    public void printOriginalOrderTotalAcount(Integer orderTotalAcount) {
        println(Title.ORIGINAL_ORDER_TOTAL_ACOUNT.msg());

        println(orderTotalAcount + "원");
        newLine();
    }

    public void printFreebieMenu(Map<String, Integer> freebies) {
        println(Title.FREEBIE_MENU.msg());

        for (Map.Entry<String, Integer> entry : freebies.entrySet()) {
            String freebie = entry.getKey();
            Integer quantity = entry.getValue();

            println(freebie + " " + quantity + "개");
        }

        notThingFreebies(freebies);
        newLine();
    }

    public void printBenefitInformations(Map<String, Integer> benefitInformations) {
        println(Title.BENEFIT_INFORMATION.msg());

        for (Map.Entry<String, Integer> entry : benefitInformations.entrySet()) {
            String title = entry.getKey();
            String discountMoney = formatNumberWithCommas(entry.getValue());

            println(title + ": -" + discountMoney + "원");
        }

        notTingBenefitInformation(benefitInformations);
        newLine();
    }

    public void printTotalDiscount(Integer totalDiscount) {
        String totalDiscountString = formatNumberWithCommas(totalDiscount);

        println(Title.TOTAL_DISCOUNT.msg());
        if (totalDiscount == 0) {
            println(totalDiscountString + "원");
        }
        if (totalDiscount != 0) {
            println("-" + totalDiscountString + "원");
        }
        newLine();
    }

    public void printFinalPayment(Integer finalPaymantMoney) {
        String finalPaymantMoneyString = formatNumberWithCommas(finalPaymantMoney);

        println(Title.FINAL_PAYMENT.msg());
        println(finalPaymantMoneyString + "원");
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
        println("없음");
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
