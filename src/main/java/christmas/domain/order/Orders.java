package christmas.domain.order;

import christmas.config.Config;
import christmas.constant.menu.MenuGroup;
import christmas.utill.Parser;

import java.util.Map;

public class Orders {

    private final Map<String, Integer> orders;
    private final OrderCalculator calculator;

    public Orders(String orderString) {
        this.orders = Parser.orders(orderString);
        this.calculator = Config.calculator();
    }

    public Integer getMainCount() {
        return getMenuCount(MenuGroup.MAIN_DISH);
    }

    public Integer getDessertCount() {
        return getMenuCount(MenuGroup.DESSERT);
    }

    public Integer getOrderMoney() {
        return calculator.getOrderMoney(orders);
    }

    public Map<String, Integer> getOrderInformation() {
        return orders;
    }

    private Integer getMenuCount(MenuGroup menuGroup) {
        Integer menuCount = 0;

        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String name = order.getKey();
            Integer quantity = order.getValue();

            if (includeMenuGroup(menuGroup, name)) {
                menuCount = menuCount + quantity;
            }
        }

        return menuCount;
    }

    private Boolean includeMenuGroup(MenuGroup menuGroup, String name) {
        return menuGroup.isMenu(name);
    }
}
