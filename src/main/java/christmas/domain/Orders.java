package christmas.domain;

import christmas.constant.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private Map<String, Integer> orders;

    public Orders(String orders) {
        this.orders = parseOrders(orders);
    }

    private Map<String, Integer> parseOrders(String input) {
        Map<String, Integer> menuMap = new HashMap<>();

        String[] orders = input.split(", ");

        for (String order : orders) {
            String[] orderParts = order.split("-");
            String menuName = orderParts[0];
            int orderQuantity = Integer.parseInt(orderParts[1]);

            menuMap.put(menuName, orderQuantity);
        }

        return menuMap;
    }

    public Integer getAppetizerCount() {
        return appetizerCount;
    }

    public Integer getMainCount() {
        return mainCount;
    }

    public Integer getDessertCount() {
        return dessertCount;
    }

    public Integer getBeverageCount() {
        return beverageCount;
    }
}
