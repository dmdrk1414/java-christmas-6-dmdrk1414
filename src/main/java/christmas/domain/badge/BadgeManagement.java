package christmas.domain.badge;

import christmas.constant.badge.Badge;

public class BadgeManagement {
    public String getBadge(Integer totalBenefit) {
        String badge = "";
        badge = getBatName(totalBenefit);

        return badge;
    }

    private String getBatName(Integer totalBenefit) {
        return Badge.getBatName(totalBenefit);
    }
}
