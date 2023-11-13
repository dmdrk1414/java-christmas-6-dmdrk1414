package christmas.validate;

import christmas.constant.validate.ValidateConstant;

public class InputValidate {

    private static final String BLANK = " ";

    public static void orderDateRange(String date) {
        Integer dateNum = parseInt(date);

        if (dateNum < 1 || dateNum > 31) {
            throwNumberFormatExceptionAboutOrderDate();
        }
    }

    public static void includeBlank(String date) {
        if (date.contains(BLANK)) {
            throwNumberFormatExceptionAboutOrderDate();
        }
    }

    private static void throwNumberFormatExceptionAboutOrderDate() {
        throw new NumberFormatException(ValidateConstant.ERROR_ORDER_DATE.getMSG());
    }

    private static Integer parseInt(String date) {
        return Integer.valueOf(date);
    }
}
