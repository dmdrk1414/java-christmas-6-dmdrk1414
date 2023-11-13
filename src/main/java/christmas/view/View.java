package christmas.view;

import christmas.config.Config;
import christmas.domain.Management;

public class View {
    private final InputView inputView;
    private final OutputView outputView;
    private final Management management;

    public View() {
        this.inputView = Config.inputView();
        this.outputView = Config.outputView();
        this.management = Config.management();
    }

    public void run() {
        printIntroduce();

        Integer orderDate = inputOrderDate();
        String orderLine = inputOrder();

        printEventPreview(orderDate);
        printOrderMenu(orderDate, orderLine);
        printOriginalOrderTotalAcount();
        printFreebies();
        printBenefitInformations();
        printTotalDiscount();
        printFinalPayment();
        printEventBadge();
    }

    private String inputOrder() {
        return inputView.readOrder();
    }

    private Integer inputOrderDate() {
        return inputView.readDate();
    }

    private void printEventBadge() {
        outputView.printEventBadge(management.getBadgeName());
    }

    private void printFinalPayment() {
        outputView.printFinalPayment(management.getFinalPayment());
    }

    private void printTotalDiscount() {
        outputView.printTotalDiscount(management.getTotalDiscount());
    }

    private void printBenefitInformations() {
        outputView.printBenefitInformations(management.getDiscountInformation());
    }

    private void printFreebies() {
        outputView.printFreebies(management.getFreebies());
    }

    private void printOriginalOrderTotalAcount() {
        outputView.printOriginalOrderTotalAcount(management.getOriginalOrderTotal());
    }

    private void printOrderMenu(Integer orderDay, String orderString) {
        outputView.printOrderMenu(management.getOrderInformation(orderDay, orderString));
    }

    private void printEventPreview(Integer orderDate) {
        outputView.printEventPreview(orderDate);
    }

    private void printIntroduce() {
        outputView.printIntroduce();
    }
}
