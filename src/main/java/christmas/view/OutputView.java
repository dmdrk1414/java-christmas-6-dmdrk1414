package christmas.view;

public class OutputView {
    public void printIntroduce() {
        print("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printEventPreview(Integer orderDate) {
        print("12월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printNewLine();
    }

    private void print(String string) {
        System.out.println(string);
    }

    private void printNewLine() {
        System.out.println();
    }
}
