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

        Integer orderDate = inputOrderDate();
        String orderLine = inputOrder();

        printEventPreview(orderDate);

        makeOrder(orderDate, orderLine);

        printOrderMenu();
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

    private void println(String string) {
        System.out.println(string);
    }
}
