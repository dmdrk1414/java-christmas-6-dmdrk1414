package christmas.validate;

import christmas.constant.view.InputConstant;

public class InputValidate {
    private static final String NOTING_STRING = "";

    public static void orderDateRange(String date) {
        Integer dateNum = parseInt(date);
        if (dateNum < 1 || dateNum > 31) {
            throw new NumberFormatException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    // TODO: 11/13/23 검증 적용 
    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new NumberFormatException(InputConstant.ERROR_BLANK_CHECK.getMSG());
    }

    private static Integer parseInt(String date) {
        return Integer.valueOf(date);
    }
}
