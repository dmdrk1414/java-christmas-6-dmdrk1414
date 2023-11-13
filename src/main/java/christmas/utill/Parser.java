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
            String menuName = getMenuName(orderParts);
            Integer orderQuantity = getOrderQuantity(orderParts);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }

    private static String getMenuName(String[] orderParts) {
        return orderParts[MENU_NAME];
    }

    private static Integer getOrderQuantity(String[] orderParts) {
        return CommonUtils.parsInt(orderParts[MENU_QUANTITY]);
    }

    private static String[] getSplitComma(String orderString) {
        return orderString.split(COMMA_REGEX);
    }

    private static String[] getSplitDash(String order) {
        return order.split(DASH_REGEX);
    }
}
