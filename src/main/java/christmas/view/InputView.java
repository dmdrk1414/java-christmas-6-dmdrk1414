package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utill.CommonUtils;

public class InputView {

    // TODO: 11/12/23 검증하기 
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer orderDate = CommonUtils.parsInt(Console.readLine());

        return orderDate;
    }

    // TODO: 11/12/23 검증하기
    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String orderString = Console.readLine();

        return orderString;
    }
}
