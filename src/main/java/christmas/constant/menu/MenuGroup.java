package christmas.constant.menu;

import java.util.Arrays;
import java.util.List;

public enum MenuGroup {
    MAIN_DISH("메인", List.of(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    APPETIZER("에피타이저", List.of(Menu.APPETIZER, Menu.TAPAS, Menu.CAESAR_SALAD)),
    DESSERT("디저트", List.of(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    BEVERAGE("음료", List.of(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE));

    private String type;
    private List<Menu> menuList;

    MenuGroup(String type, List<Menu> menuList) {
        this.type = type;
        this.menuList = menuList;
    }

    public static List<MenuGroup> getAllMenuGroups() {
        return Arrays.asList(values());
    }

    public static Boolean isBeverage(String orderMenu) {
        return BEVERAGE.isMenu(orderMenu);
    }

    public Boolean isMenu(String orderMenu) {
        return menuList.stream()
                .anyMatch(menu -> menu.is(orderMenu));
    }

    public Integer getMenuPrice(String orderMenu) {
        return menuList.stream()
                .filter(menu -> menu.is(orderMenu))
                .findFirst()
                .map(Menu::getPrice)
                .orElse(0);
    }
}
