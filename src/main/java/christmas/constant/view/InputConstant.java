package christmas.constant.view;

public enum InputConstant {
    ERROR_BLANK_CHECK("[ERROR] 빈칸은 입력할 수 없습니다.");

    private String constant;

    InputConstant(String constant) {
        this.constant = constant;
    }

    public String getMSG() {
        return constant;
    }
}
