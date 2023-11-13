package christmas.validate;

import christmas.constant.validate.ValidateConstant;

public class InputValidate {
    public static void orderDateRange(String date) {
        Integer dateNum = parseInt(date);
        
        if (dateNum < 1 || dateNum > 31) {
            thorwNumberFormatExceptionAboutOrderDate();
        }
    }

    private static void thorwNumberFormatExceptionAboutOrderDate() {
        throw new NumberFormatException(ValidateConstant.ERROR_ORDER_DATE.getMSG());
    }

    private static Integer parseInt(String date) {
        return Integer.valueOf(date);
    }
}
