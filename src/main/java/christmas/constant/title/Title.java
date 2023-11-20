package christmas.constant.title;

public enum Title {
    INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ORDER_MENU("<주문 메뉴>"),
    ORIGINAL_ORDER_TOTAL_ACOUNT("<할인 전 총주문 금액>"),
    FREEBIE_MENU("<증정 메뉴>"),
    BENEFIT_INFORMATION("<혜택 내역>"),
    TOTAL_DISCOUNT("<총혜택 금액>"),
    FINAL_PAYMENT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String msg() {
        return title;
    }
}
