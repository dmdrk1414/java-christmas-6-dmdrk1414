package christmas.validate;

import christmas.constant.validate.ValidateConstant;

public class ValidateOrder {
    private static final String SEQUENCE_COMMA = ",,";
    private static final String BLANK = " ";

    // 1. 고객이 메뉴판에 없는 메뉴를 입력하는 경우,
    // 2. 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요.
    // 3. 메뉴 형식이 예시와 다른 경우,
    // 4. 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1),

    public static void hasConsecutiveEmptyValues(String strLine) {
        if (strLine.contains(SEQUENCE_COMMA)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    public static void includeBlank(String date) {
        if (date.contains(BLANK)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    private static void throwNumberFormatExceptionAboutOrder() {
        throw new NumberFormatException(ValidateConstant.ERROR_ORDER.getMSG());
    }
}
