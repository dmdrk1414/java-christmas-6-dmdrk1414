package christmas.inputview;

import camp.nextstep.edu.missionutils.Console;
import christmas.utill.CommonUtils;

public class InputView {

    // TODO: 11/12/23 검증하기 
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer orderDate = CommonUtils.parsInt(Console.readLine());

        return orderDate;
    }
}
