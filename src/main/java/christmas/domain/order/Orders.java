package christmas.domain.order;

import christmas.config.Config;
import christmas.constant.menu.MenuGroup;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private static final String COMMA_REGEX = ",";
    private static final String DASH_REGEX = "-";
    private static final Integer MENU_NAME = 0;
    private static final Integer MENU_QUANTITY = 1;
    private final Map<String, Integer> orders;
    private final OrderCalculator calculator;

    public Orders(String orders) {
        this.orders = parseOrders(orders);
        this.calculator = Config.calculator();
    }

    public Integer getAppetizerCount() {
        Integer appetizerCount = getMenuCount(MenuGroup.APPETIZER);

        return appetizerCount;
    }

    public Integer getMainCount() {
        Integer mainCount = getMenuCount(MenuGroup.MAIN_DISH);

        return mainCount;
    }

    public Integer getDessertCount() {
        Integer dessertCount = getMenuCount(MenuGroup.DESSERT);

        return dessertCount;
    }

    public Integer getBeverageCount() {
        Integer beveragetCount = getMenuCount(MenuGroup.BEVERAGE);

        return beveragetCount;
    }

    public Integer getOrderMoney() {
        Integer orderMoney = calculator.getOrderMoney(orders);

        return orderMoney;
    }

    public Map<String, Integer> getOrderInformation() {
        return orders;
    }

    private Integer getMenuCount(MenuGroup appetizer) {
        Integer menuCount = 0;
        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String item = order.getKey();
            Integer quantity = order.getValue();
            Boolean isCondition = appetizer.isMenu(item);

            if (isCondition) {
                menuCount = menuCount + quantity;
            }
        }
        return menuCount;
    }

    private Map<String, Integer> parseOrders(String input) {
        Map<String, Integer> menuMap = new HashMap<>();

        String[] orders = input.split(COMMA_REGEX);

        for (String order : orders) {
            String[] orderParts = order.split(DASH_REGEX);
            String menuName = orderParts[MENU_NAME];
            int orderQuantity = Integer.parseInt(orderParts[MENU_QUANTITY]);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }
}
