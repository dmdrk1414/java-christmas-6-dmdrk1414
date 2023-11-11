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
        Integer appetizerCount = 0;

        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String item = order.getKey();
            Integer quantity = order.getValue();

            Boolean isAppetizer = MenuGroup.APPETIZER.isMenu(item);
            if (isAppetizer) {
                appetizerCount = appetizerCount + quantity;
            }
        }
        return appetizerCount;
    }

    public Integer getMainCount() {
        return null;
    }

    public Integer getDessertCount() {
        return null;
    }

    public Integer getBeverageCount() {
        return null;
    }

//    // TODO: 11/11/23 주문을 할때 준문의 총금액 구현
//    public Integer getOrderMoney() {
//        Integer orderMoney = 0;
//
//        orderMoney = Menu.
//
//        return orderMoney;
//    }
}
