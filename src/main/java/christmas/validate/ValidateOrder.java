package christmas.validate;

import christmas.constant.menu.MenuGroup;
import christmas.constant.validate.ValidateConstant;
import christmas.utill.CommonUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateOrder {
    private static final List<MenuGroup> menuGroups = List.of(MenuGroup.MAIN_DISH, MenuGroup.APPETIZER, MenuGroup.DESSERT, MenuGroup.BEVERAGE);
    private static final String SEQUENCE_COMMA = ",,";
    private static final String BLANK = " ";
    private static final Character COMMA_CHAR = ',';
    private static final String DASH_REGEX = "-";
    private static final String COMMAR_REGEX = ",";
    private static final Integer MENU_NAME = 0;
    private static final Integer MENU_QUANTITY = 1;
    private static final String DASH = "-";
    private static final String NUMERIC_REGEX = "\\d+";
    private static final Integer SPLIT_PART_SIZE = 2;
    private static final Integer MAX_MENU_COUNT = 20;
    private static final String KOREA_REGEX = "^[가-힣]+$";

    public static void hasConsecutiveEmptyValues(String strLine) {
        if (strLine.contains(SEQUENCE_COMMA)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    public static void includeBlank(String date) {
        if (date.contains(BLANK)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    public static void commaStartOrEnd(String strLine) {
        int length = strLine.length();

        if (strLine.charAt(length - 1) == COMMA_CHAR || strLine.charAt(0) == COMMA_CHAR) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    public static void empty(String order) {
        if (order == null || order.isEmpty()) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    public static void collectFormat(String order) {
        String[] orderArr = order.split(COMMAR_REGEX);
        for (String orderValue : orderArr) {
            isincludDash(orderValue);

            String[] partsOfDash = orderValue.split(DASH_REGEX);
            hasOrderAndQuantitySize(partsOfDash);

            String itemName = partsOfDash[MENU_NAME];
            String quantityStr = partsOfDash[MENU_QUANTITY];

            hasKoreaMenuDashQuantity(itemName, quantityStr);
        }
    }

    public static void menuCount(String orderString) {
        String[] orderArr = orderString.split(COMMAR_REGEX);

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String quantityStr = partsOfDash[MENU_QUANTITY];

            if (CommonUtils.parsInt(quantityStr) < 1) {
                throwNumberFormatExceptionAboutOrder();
            }
        }
    }

    public static void onlyBeverage(String orderString) {
        String[] orderArr = orderString.split(COMMAR_REGEX);

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String menu = partsOfDash[MENU_NAME];

            if (!MenuGroup.isBeverage(menu)) {
                return;
            }
        }
        throwNumberFormatExceptionAboutOrder();
    }

    public static void notExistenceMenu(String orderString) {
        String[] orderArr = orderString.split(COMMAR_REGEX);

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String menu = partsOfDash[MENU_NAME];
            if (notExistMenu(menu)) {
                throwNumberFormatExceptionAboutOrder();
            }
        }
    }

    public static void duplicateMenu(String orderString) {
        Set<String> uniqueOrders = new HashSet<>();
        String[] orderArr = orderString.split(COMMAR_REGEX);

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String menu = partsOfDash[MENU_NAME];
            if (!uniqueOrders.add(menu)) {
                throwNumberFormatExceptionAboutOrder();
            }
        }
    }

    public static void maxMenuCount(String orderString) {
        String[] orderArr = orderString.split(COMMAR_REGEX);
        Integer totalQuantity = 0;

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String menuQuantity = partsOfDash[MENU_QUANTITY];
            totalQuantity = totalQuantity + CommonUtils.parsInt(menuQuantity);

            if (totalQuantity > MAX_MENU_COUNT) {
                throwNumberFormatExceptionAboutOrder();
            }
        }
    }

    private static Boolean notExistMenu(String orderString) {
        return !menuGroups.stream()
                .anyMatch(menuGroup -> menuGroup.isMenu(orderString));
    }

    private static void hasKoreaMenuDashQuantity(String menuName, String quantity) {
        if (!menuContainsOnlyKorea(menuName) || !isNumeric(quantity)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    private static void hasOrderAndQuantitySize(String[] parts) {
        if (parts.length != SPLIT_PART_SIZE) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    private static void isincludDash(String orderItem) {
        if (!orderItem.contains(DASH)) {
            throwNumberFormatExceptionAboutOrder();
        }
    }

    private static boolean menuContainsOnlyKorea(String str) {
        Pattern pattern = Pattern.compile(KOREA_REGEX);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private static boolean isNumeric(String str) {
        return str.matches(NUMERIC_REGEX);
    }

    private static void throwNumberFormatExceptionAboutOrder() {
        throw new NumberFormatException(ValidateConstant.ERROR_ORDER.getMSG());
    }
}
