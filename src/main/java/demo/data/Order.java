package demo.data;

import java.util.List;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Order {

    private static Integer price;
    private static Integer lot;
    private static List<String> orderId;
    private static String autoOrderType = "";

    public static void setPrice(Integer price) {
        Order.price = price;
    }

    public static Integer getPrice() {
        return price;
    }

    public static void setLot(Integer lot) {
        Order.lot = lot;
    }

    public static Integer getLot() {
        return lot;
    }

    public static void setOrderId(List<String> orderId) {
        Order.orderId = orderId;
    }

    public static List<String> getOrderId() {
        return orderId;
    }

    public static void setAutoOrderType(String autoOrderType) {
        Order.autoOrderType = autoOrderType;
    }

    public static String getAutoOrderType() {
        return autoOrderType;
    }
}
