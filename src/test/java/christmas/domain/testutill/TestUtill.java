package christmas.domain.testutill;

public class TestUtill {
    public static String insertComma(String input) {
        return input.replaceAll("-(\\d)", "-$1,");
    }

}
