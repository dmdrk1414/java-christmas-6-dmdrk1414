package christmas.domain;

import christmas.constant.menu.Menu;

public class Freebie {
    private String champagne;

    public Freebie() {
        this.champagne = Menu.CHAMPAGNE.getName();
    }

    public String getChampagne() {
        return champagne;
    }
}
