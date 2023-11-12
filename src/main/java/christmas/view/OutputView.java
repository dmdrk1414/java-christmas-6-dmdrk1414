package christmas.view;

import java.util.Map;

public class OutputView {
    public void printIntroduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printEventPreview(Integer orderDate) {
        println("12월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printNewLine();
    }

    public void printOrderMenu(Map<String, Integer> orders) {
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();

            println(menu + " " + quantity + "개");
        }
    }

    private void println(String string) {
        System.out.println(string);
    }

    private void printNewLine() {
        System.out.println();
    }
}
