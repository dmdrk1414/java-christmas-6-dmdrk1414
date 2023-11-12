package christmas.constant.discount;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private static final String NOTTING = "없음";
    private String name;
    private Integer condition;

    Badge(String name, Integer condition) {
        this.name = name;
        this.condition = condition;
    }

    public static String getBatName(Integer totalBenefit) {
        if (isSanta(totalBenefit)) {
            return SANTA.getName();
        }
        if (isTree(totalBenefit)) {
            return TREE.getName();
        }
        if (isStar(totalBenefit)) {
            return STAR.getName();
        }
        return NOTTING;
    }

    private static Boolean isStar(Integer totalBenefit) {
        return totalBenefit >= STAR.condition;
    }

    private static Boolean isTree(Integer totalBenefit) {
        return totalBenefit >= TREE.condition;
    }

    private static Boolean isSanta(Integer totalBenefit) {
        return totalBenefit >= SANTA.condition;
    }

    public String getName() {
        return name;
    }

    public Integer getCondition() {
        return condition;
    }

    public Boolean isCondition(Integer totalDiscount) {
        return totalDiscount >= getCondition();
    }
}
