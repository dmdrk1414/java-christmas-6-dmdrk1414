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


}
