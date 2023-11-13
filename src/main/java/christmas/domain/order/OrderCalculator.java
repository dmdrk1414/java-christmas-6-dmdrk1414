package christmas.domain.order;

import christmas.constant.menu.MenuGroup;

import java.util.List;
import java.util.Map;

public class OrderCalculator {

    public Integer getOrderMoney(Map<String, Integer> orders) {
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
}
