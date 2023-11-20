package christmas.constant.freebie;

public enum Freebies {
    CHAMPAGNE("샴페인", 25_000, 1);

    private final String name;
    private final Integer price;
    private final Integer count;

    Freebies(String name, Integer price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }
}
