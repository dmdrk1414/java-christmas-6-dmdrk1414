package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utill.CommonUtils;
import christmas.validate.ValidateOrder;
import christmas.validate.ValidateOrderDate;

public class InputView {


    // TODO: 11/12/23 검증하기
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        while (true) {
            try {
                String orderDateString = Console.readLine().trim();
                validateReadDate(orderDateString);

                return CommonUtils.parsInt(orderDateString);
            } catch (NumberFormatException e) {
                println(e.getMessage());
            }
        }
    }

    //  적용
    private void validateReadDate(String orderDateString) {
        ValidateOrderDate.includeBlank(orderDateString);
        ValidateOrderDate.includeString(orderDateString);
        ValidateOrderDate.orderDateRange(orderDateString);
    }

    // TODO: 11/12/23 검증하기

    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        while (true) {
            try {
                String orderString = Console.readLine().trim();
                validateReadOrder(orderString);

                return orderString;
            } catch (NumberFormatException e) {
                println(e.getMessage());
            }
        }
    }

    private void validateReadOrder(String orderString) {
        ValidateOrder.empty(orderString);
        ValidateOrder.hasConsecutiveEmptyValues(orderString);
        ValidateOrder.includeBlank(orderString);
        ValidateOrder.commaStartOrEnd(orderString);
        ValidateOrder.collectFormat(orderString);
        ValidateOrder.menuCount(orderString);
        ValidateOrder.onlyBeverage(orderString);
        ValidateOrder.notExistenceMenu(orderString);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
