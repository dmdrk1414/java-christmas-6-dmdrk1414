package christmas.constant.discount;

public enum Discount {
    // 디 디데이 할인
    D_DAY_ONE(1, 1000),
    D_DAY_TWO(2, 1100),
    D_DAY_THREE(3, 1200),
    D_DAY_FOUR(4, 1300),
    D_DAY_FIVE(5, 1400),
    D_DAY_SIX(6, 1500),
    D_DAY_SEVEN(7, 1600),
    D_DAY_EIGHT(8, 1700),
    D_DAY_NINE(9, 1800),
    D_DAY_TEN(10, 1900),
    D_DAY_ELEVEN(11, 2000),
    D_DAY_TWELVE(12, 2100),
    D_DAY_THIRTEEN(13, 2200),
    D_DAY_FOURTEEN(14, 2300),
    D_DAY_FIFTEEN(15, 2400),
    D_DAY_SIXTEEN(16, 2500),
    D_DAY_SEVENTEEN(17, 2600),
    D_DAY_EIGHTEEN(18, 2700),
    D_DAY_NINETEEN(19, 2800),
    D_DAY_TWENTY(20, 2900),
    D_DAY_TWENTY_ONE(21, 3000),
    D_DAY_TWENTY_TWO(22, 3100),
    D_DAY_TWENTY_THREE(23, 3200),
    D_DAY_TWENTY_FOUR(24, 3300),
    D_DAY_TWENTY_FIVE(25, 3400),

    // 평일 할인
    WEEK_DAY_THREE(3, 2023),
    WEEK_DAY_FOUR(4, 2023),
    WEEK_DAY_FIVE(5, 2023),
    WEEK_DAY_SIX(6, 2023),
    WEEK_DAY_SEVEN(7, 2023),
    WEEK_DAY_TEN(10, 2023),
    WEEK_DAY_ELEVEN(11, 2023),
    WEEK_DAY_TWELVE(12, 2023),
    WEEK_DAY_THIRTEEN(13, 2023),
    WEEK_DAY_FOURTEEN(14, 2023),
    WEEK_DAY_SEVENTEEN(17, 2023),
    WEEK_DAY_EIGHTEEN(18, 2023),
    WEEK_DAY_NINETEEN(19, 2023),
    WEEK_DAY_TWENTY(20, 2023),
    WEEK_DAY_TWENTY_ONE(21, 2023),
    WEEK_DAY_TWENTY_FOUR(24, 2023),
    WEEK_DAY_TWENTY_FIVE(25, 2023),
    WEEK_DAY_TWENTY_SIX(26, 2023),
    WEEK_DAY_TWENTY_SEVEN(27, 2023),
    WEEK_DAY_TWENTY_EIGHT(28, 2023),
    WEEK_DAY_THIRTY_ONE(31, 2023),

    // 주말 할인
    WEEKEND_DAY_ONE(1, 2023),
    WEEKEND_DAY_TWO(2, 2023),
    WEEKEND_DAY_EIGHT(8, 2023),
    WEEKEND_DAY_NINE(9, 2023),
    WEEKEND_DAY_FIFTEEN(15, 2023),
    WEEKEND_DAY_SIXTEEN(16, 2023),
    WEEKEND_DAY_TWENTY_TWO(22, 2023),
    WEEKEND_DAY_TWENTY_THREE(23, 2023),
    WEEKEND_DAY_TWENTY_NINE(29, 2023),
    WEEKEND_DAY_THIRTY(30, 2023),

    // 특별 할인
    SPECIAL_DAY_THREE(3, 1000),
    SPECIAL_DAY_TEN(10, 1000),
    SPECIAL_DAY_SEVENTEEN(17, 1000),
    SPECIAL_DAY_TWENTY_FOUR(24, 1000),
    SPECIAL_DAY_TWENTY_FIVE(25, 1000),
    SPECIAL_DAY_THIRTY_ONE(31, 1000);

    private final int day;
    private final int discountAmount;

    Discount(int day, int discountAmount) {
        this.day = day;
        this.discountAmount = discountAmount;
    }

    public int getDay() {
        return day;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public Boolean is(Integer order) {
        return getDay() == order;
    }

}
