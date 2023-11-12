package christmas.view;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    public void printIntroduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printEventPreview(Integer orderDate) {
        println("12월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        newLine();
    }

    public void printOrderMenu(Map<String, Integer> orders) {
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();

            println(menu + " " + quantity + "개");
        }
        newLine();
    }

    public void printOriginalOrderTotalAcount(Integer orderTotalAcount) {
        println("<할인 전 총주문 금액>");
        println(orderTotalAcount + "원");
        newLine();
    }

    public void printFreebies(Map<String, Integer> freebies) {
        for (Map.Entry<String, Integer> entry : freebies.entrySet()) {
            String freebie = entry.getKey();
            Integer quantity = entry.getValue();

            println(freebie + " " + quantity + "개");
        }

        if (freebies.isEmpty()) {
            printNotThing();
        }
    }

    //<혜택 내역>
    //크리스마스 디데이 할인: -1,200원
    //평일 할인: -4,046원
    //특별 할인: -1,000원
    //증정 이벤트: -25,000원
    // 없으면 낫팅
    public void printBenefitInformations(Map<String, Integer> benefitInformations) {
        for (Map.Entry<String, Integer> entry : benefitInformations.entrySet()) {
            String title = entry.getKey();
            String discountMoney = formatNumberWithCommas(entry.getValue());

            println(title + ": -" + discountMoney + "원");
        }

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
}
