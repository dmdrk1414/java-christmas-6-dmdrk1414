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
        printFreebieMenu();
        printBenefitInformations();
        printTotalBenefit();
        printFinalPayment();
        printEventBadge();
    }

    private void printIntroduce() {
        outputView.printIntroduce();
    }

    private Integer inputOrderDate() {
        return inputView.readDate();
    }

    private String inputOrder() {
        return inputView.readOrder();
    }

    private void printEventPreview(Integer orderDate) {
        outputView.printEventPreview(orderDate);
    }

    private void printOrderMenu(Integer orderDay, String orderString) {
        outputView.printOrderMenu(management.getOrderInformation(orderDay, orderString));
    }

    private void printOriginalOrderTotalAcount() {
        outputView.printOriginalOrderTotalAcount(management.getOriginalOrderTotal());
    }

    private void printFreebieMenu() {
        outputView.printFreebieMenu(management.getFreebieMenu());
    }

    private void printBenefitInformations() {
        outputView.printBenefitInformations(management.getDiscountInformation());
    }

    private void printTotalBenefit() {
        outputView.printTotalDiscount(management.getTotalBenefit());
    }

    private void printFinalPayment() {
        outputView.printFinalPayment(management.getFinalPayment());
    }

    private void printEventBadge() {
        outputView.printEventBadge(management.getBadgeName());
    }
}
