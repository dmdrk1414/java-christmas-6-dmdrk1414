package christmas.constant.validate;

public enum ValidateConstant {
    ERROR_ORDER_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String constant;

    ValidateConstant(String constant) {
        this.constant = constant;
    }

    public String getMSG() {
        return constant;
    }
}
