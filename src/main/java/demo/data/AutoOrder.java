package demo.data;

public class AutoOrder {
    private static String condition;
    private static String sscondition;
    private static String ssscondition;

    public static void setCondition(String condition) {
        AutoOrder.condition = condition;
    }

    public static String getCondition() {
        return condition;
    }
}
