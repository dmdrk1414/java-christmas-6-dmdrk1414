package christmas.domain.badge;

import christmas.constant.badge.Badge;

public class BadgeManagement {
    public String getBadge(Integer totalBenefit) {
        return getBatName(totalBenefit);
    }

    private String getBatName(Integer totalBenefit) {
        return Badge.getBatName(totalBenefit);
    }
}
