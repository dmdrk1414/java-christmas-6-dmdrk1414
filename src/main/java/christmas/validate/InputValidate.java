package christmas.validate;

public class InputValidate {
    public static void orderDateRange(String date) {
        Integer dateNum = parseInt(date);
        if (dateNum < 1 || dateNum > 31) {
            throw new NumberFormatException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static Integer parseInt(String date) {
        return Integer.valueOf(date);
    }
}
