package demo.data;

import java.util.List;

public class Stock {
    private static String stockName;
    private static List<String> companyId;
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Stock.id = id;
    }

    public static void setStockName(String stockName) {
        Stock.stockName = stockName;
    }

    public static String getStockName() {
        return stockName;
    }

    public static void setCompanyId(List<String> companyId) {
        Stock.companyId = companyId;
    }

    public static List<String> getCompanyId() {
        return companyId;
    }
}
