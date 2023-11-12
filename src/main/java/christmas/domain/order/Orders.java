package christmas.domain.order;

import christmas.config.Config;
import christmas.constant.menu.MenuGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private Map<String, Integer> orders;
    private Calculator calculator;

    public Orders(String orders) {
        this.orders = parseOrders(orders);
        this.calculator = Config.calculator(this.orders);
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
        Integer orderMoney = calculator.getOrderMoney();
        return orderMoney;
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

        String[] orders = input.split(",");

        for (String order : orders) {
            String[] orderParts = order.split("-");
            String menuName = orderParts[0];
            int orderQuantity = Integer.parseInt(orderParts[1]);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }
}
