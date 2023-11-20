package christmas;

import christmas.config.Config;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.view.View;

public class Application {

    public static void main(String[] args) {
        View view = Config.view();
        view.run();
    }
}
