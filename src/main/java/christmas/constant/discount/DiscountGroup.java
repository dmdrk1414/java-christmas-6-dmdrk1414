package christmas.constant.discount;

import java.util.Arrays;
import java.util.List;

public enum DiscountGroup {
    D_DAY_DISCOUNT("크리스마스 디데이 할인", Arrays.asList(
            Discount.D_DAY_ONE, Discount.D_DAY_TWO, Discount.D_DAY_THREE,
            Discount.D_DAY_FOUR, Discount.D_DAY_FIVE, Discount.D_DAY_SIX,
            Discount.D_DAY_SEVEN, Discount.D_DAY_EIGHT, Discount.D_DAY_NINE,
            Discount.D_DAY_TEN, Discount.D_DAY_ELEVEN, Discount.D_DAY_TWELVE,
            Discount.D_DAY_THIRTEEN, Discount.D_DAY_FOURTEEN, Discount.D_DAY_FIFTEEN,
            Discount.D_DAY_SIXTEEN, Discount.D_DAY_SEVENTEEN, Discount.D_DAY_EIGHTEEN,
            Discount.D_DAY_NINETEEN, Discount.D_DAY_TWENTY, Discount.D_DAY_TWENTY_ONE,
            Discount.D_DAY_TWENTY_TWO, Discount.D_DAY_TWENTY_THREE, Discount.D_DAY_TWENTY_FOUR,
            Discount.D_DAY_TWENTY_FIVE)),
    WEEK_DAY_DISCOUNT("평일 할인", Arrays.asList(
            Discount.WEEK_DAY_THREE, Discount.WEEK_DAY_FOUR, Discount.WEEK_DAY_FIVE,
            Discount.WEEK_DAY_SIX, Discount.WEEK_DAY_SEVEN, Discount.WEEK_DAY_TEN,
            Discount.WEEK_DAY_ELEVEN, Discount.WEEK_DAY_TWELVE, Discount.WEEK_DAY_THIRTEEN,
            Discount.WEEK_DAY_FOURTEEN, Discount.WEEK_DAY_SEVENTEEN, Discount.WEEK_DAY_EIGHTEEN,
            Discount.WEEK_DAY_NINETEEN, Discount.WEEK_DAY_TWENTY, Discount.WEEK_DAY_TWENTY_ONE,
            Discount.WEEK_DAY_TWENTY_FOUR, Discount.WEEK_DAY_TWENTY_FIVE, Discount.WEEK_DAY_TWENTY_SIX,
            Discount.WEEK_DAY_TWENTY_SEVEN, Discount.WEEK_DAY_TWENTY_EIGHT, Discount.WEEK_DAY_THIRTY_ONE)),

    WEEKEND_DAY_DISCOUNT("주말 할인", Arrays.asList(
            Discount.WEEKEND_DAY_ONE, Discount.WEEKEND_DAY_TWO, Discount.WEEKEND_DAY_EIGHT,
            Discount.WEEKEND_DAY_NINE, Discount.WEEKEND_DAY_FIFTEEN, Discount.WEEKEND_DAY_SIXTEEN,
            Discount.WEEKEND_DAY_TWENTY_TWO, Discount.WEEKEND_DAY_TWENTY_THREE, Discount.WEEKEND_DAY_TWENTY_NINE,
            Discount.WEEKEND_DAY_THIRTY)),

    SPECIAL_DAY_DISCOUNT("특별 할인", Arrays.asList(
            Discount.SPECIAL_DAY_THREE, Discount.SPECIAL_DAY_TEN, Discount.SPECIAL_DAY_SEVENTEEN,
            Discount.SPECIAL_DAY_TWENTY_FOUR, Discount.SPECIAL_DAY_TWENTY_FIVE, Discount.SPECIAL_DAY_THIRTY_ONE));

    private String title;
    private List<Discount> discountList;

    DiscountGroup(String title, List<Discount> discountList) {
        this.title = title;
        this.discountList = discountList;
    }

    public Boolean hasDiscount(Integer orderDay) {
        return discountList.stream()
                .anyMatch(dDays -> dDays.is(orderDay));
    }

    public Integer getAmount(Integer orderDay) {
        return discountList.stream()
                .filter(discount -> discount.is(orderDay))
                .findFirst()
                .map(Discount::getDiscountAmount)
                .orElse(0);
    }
}
