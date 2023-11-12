package christmas.constant.discount;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private String name;
    private Integer condition;

    Badge(String name, Integer condition) {
        this.name = name;
        this.condition = condition;
    }
}
