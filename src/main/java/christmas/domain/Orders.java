package christmas.domain;

import christmas.constant.menu.MenuGroup;

import java.util.HashMap;
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


    //    // TODO: 11/11/23 주문을 할때 준문의 총금액 구현
//    public Integer getOrderMoney() {
//        Integer orderMoney = 0;
//
//        orderMoney = Menu.
//
//        return orderMoney;
//    }
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
