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
        outputView.printIntroduce();

        Integer orderDate = inputView.readDate();
        String orderLine = inputView.readOrder();

        outputView.printEventPreview(orderDate);

        management.generateOrder(orderDate, orderLine);

        outputView.printOrderMenu(management.getOrderInformation());
        outputView.printOriginalOrderTotalAcount(management.getOriginalOrderTotal());
        outputView.printFreebies(management.getFreebies());
        outputView.printBenefitInformations(management.getDiscountInformation());
        outputView.printTotalDiscount(management.getTotalDiscount());
        outputView.printFinalPayment(management.getFinalPayment());
        outputView.printEventBadge(management.getBadgeName());
    }
}
