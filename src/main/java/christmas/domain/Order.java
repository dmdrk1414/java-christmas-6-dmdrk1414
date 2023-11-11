package christmas.domain;

public class Order {
    private Integer appetizerCount;
    private Integer mainCount;
    private Integer dessertCount;
    private Integer beverageCount;

    public Order(Integer appetizerCount, Integer mainCount, Integer dessertCount, Integer beverageCount) {
        this.appetizerCount = appetizerCount;
        this.mainCount = mainCount;
        this.dessertCount = dessertCount;
        this.beverageCount = beverageCount;
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
