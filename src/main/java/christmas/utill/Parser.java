package christmas.utill;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static final String COMMA_REGEX = ",";
    private static final String DASH_REGEX = "-";
    private static final Integer MENU_NAME = 0;
    private static final Integer MENU_QUANTITY = 1;

    public static Map<String, Integer> orders(String orderString) {
        Map<String, Integer> menuMap = new HashMap<>();
        String[] orders = getSplitComma(orderString);

        for (String order : orders) {
            String[] orderParts = getSplitDash(order);
            String menuName = orderParts[MENU_NAME];
            Integer orderQuantity = CommonUtils.parsInt(orderParts[MENU_QUANTITY]);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }

    private static String[] getSplitComma(String orderString) {
        return orderString.split(COMMA_REGEX);
    }

    private static String[] getSplitDash(String order) {
        return order.split(DASH_REGEX);
    }
}
