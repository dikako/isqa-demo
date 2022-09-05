package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Calendar {

    private static String calendarSymbol = "NoSuchElement";

    public static void setCalendarSymbol(String symbol) {
        Calendar.calendarSymbol = symbol;
    }

    public static String getCalendarSymbol() {
        return calendarSymbol;
    }
}
