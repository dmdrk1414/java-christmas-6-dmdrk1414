package christmas.validate;

import christmas.constant.validate.ValidateConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateOrderDate {

    private static final String BLANK = " ";
    private static final String KOREAN_ENGLISH_REGEX = ".*[^0-9\\s].*";

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

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
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
