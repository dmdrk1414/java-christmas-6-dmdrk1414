package christmas.domain.badge;

import christmas.constant.discount.Badge;

import java.util.ArrayList;
import java.util.List;

public class BadgeManagement {
    private List<Badge> BadgeManagement;

    public BadgeManagement() {
        BadgeManagement = List.of(Badge.STAR, Badge.TREE, Badge.SANTA);
    }

    public String getBadge(Integer totalBenefit) {
        String badge = "";

        badge = getBatName(totalBenefit);

        return badge;
    }

    private String getBatName(Integer totalBenefit) {
        return Badge.getBatName(totalBenefit);
    }
}
