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
        String[] orders = orderString.split(COMMA_REGEX);

        for (String order : orders) {
            String[] orderParts = order.split(DASH_REGEX);
            String menuName = orderParts[MENU_NAME];
            int orderQuantity = Integer.parseInt(orderParts[MENU_QUANTITY]);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }
}
