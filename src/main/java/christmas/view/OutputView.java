package christmas.view;

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

        if (freebies.size() == 0) {
            printNotThing();
        }
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
