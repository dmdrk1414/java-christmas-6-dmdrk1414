package christmas.view;

import christmas.config.Config;
import christmas.domain.Management;

public class View {
    private InputView inputView;
    private OutputView outputView;
    private Management management;

    public View() {
        this.inputView = Config.inputView();
        this.outputView = Config.outputView();
        this.management = Config.management();
    }

    public void run() {
        printIntroduce();

        Integer orderDate = inputView.readDate();
        String orderLine = inputView.readOrder();

        printEventPreview(orderDate);

        makeOrder(orderDate, orderLine);

        printOrderMenu();
        printOriginalOrderTotalAcount();
        printFreebies();
        printBenefitInformations();
        outputView.printTotalDiscount(management.getTotalDiscount());
        outputView.printFinalPayment(management.getFinalPayment());
        outputView.printEventBadge(management.getBadgeName());
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

    private void printOrderMenu() {
        outputView.printOrderMenu(management.getOrderInformation());
    }

    private void makeOrder(Integer orderDate, String orderLine) {
        management.generateOrder(orderDate, orderLine);
    }

    private void printEventPreview(Integer orderDate) {
        outputView.printEventPreview(orderDate);
    }

    private void printIntroduce() {
        outputView.printIntroduce();
    }
}
