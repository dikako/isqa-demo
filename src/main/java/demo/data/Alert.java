package demo.data;

import java.util.List;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Alert {

    private static Integer price;

    private static List<String> id;

    public static void setPriceAlert(Integer price) {
        Alert.price = price;
    }

    public static Integer getPriceAlert() {
        return price;
    }

    public static void setId(List<String> alertId) {
        Alert.id = alertId;
    }

    public static List<String> getId() {
        return id;
    }
}
