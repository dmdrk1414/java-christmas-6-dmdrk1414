package christmas.domain.order;

import christmas.constant.menu.MenuGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private Map<String, Integer> orders;

    public Orders(String orders) {
        this.orders = parseOrders(orders);
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
        Integer orderMoney = 0;
        Integer menuPrice = 0;

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menuName = entry.getKey();
            Integer menuQuantity = entry.getValue();

            menuPrice = getMenuPrice(menuName);
            orderMoney = orderMoney + (menuPrice * menuQuantity);
        }
        return orderMoney;
    }

    private Integer getMenuPrice(String menuName) {
        Integer menuPrice = 0;
        List<MenuGroup> menuGroups = MenuGroup.getAllMenuGroups();

        for (MenuGroup menuGroup : menuGroups) {
            if (menuGroup.isMenu(menuName)) {
                menuPrice = menuGroup.getMenuPrice(menuName);
                break;
            }
        }

        return menuPrice;
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
}
