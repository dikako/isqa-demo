package demo.data;

import java.util.List;

/**
 * Created by fransiskusandika 22/08/2022
 */
public class StockTransfer {
    private static String customerCode;
    private static String noSecuritiesSubAccount;
    private static String noRdnOriginalSecurities;
    private static String reasonForTransfer;
    private static String stockSymbol;
    private static String numberOfSheets;
    private static String price;
    private static int StockSymbolAdded = 0;
    private static String stockTransferId = "";
    private static String securities;
    private static String securitiesCode;
    private static String noKtp;
    private static String address;
    private static String noIdentityCardKTPOrPassport;
    private static List<String> fields;
    private static boolean entryPoint;

    public static String getCustomerCode() {
        return customerCode;
    }

    public static void setCustomerCode(String customerCode) {
        StockTransfer.customerCode = customerCode;
    }

    public static String getNoSecuritiesSubAccount() {
        return noSecuritiesSubAccount;
    }

    public static void setNoSecuritiesSubAccount(String noSecuritiesSubAccount) {
        StockTransfer.noSecuritiesSubAccount = noSecuritiesSubAccount;
    }

    public static String getNoRdnOriginalSecurities() {
        return noRdnOriginalSecurities;
    }

    public static void setNoRdnOriginalSecurities(String noRdnOriginalSecurities) {
        StockTransfer.noRdnOriginalSecurities = noRdnOriginalSecurities;
    }

    public static String getReasonForTransfer() {
        return reasonForTransfer;
    }

    public static void setReasonForTransfer(String reasonForTransfer) {
        StockTransfer.reasonForTransfer = reasonForTransfer;
    }

    public static String getStockSymbol() {
        return stockSymbol;
    }

    public static void setStockSymbol(String stockSymbol) {
        StockTransfer.stockSymbol = stockSymbol;
    }

    public static String getNumberOfSheets() {
        return numberOfSheets;
    }

    public static void setNumberOfSheets(String numberOfSheets) {
        StockTransfer.numberOfSheets = numberOfSheets;
    }

    public static String getPrice() {
        return price + ".00";
    }

    public static void setPrice(String price) {
        StockTransfer.price = price;
    }

    public static int getStockSymbolAdded() {
        return StockSymbolAdded;
    }

    public static void setStockSymbolAdded(int stockSymbolAdded) {
        StockSymbolAdded = stockSymbolAdded;
    }

    public static String getStockTransferId() {
        return stockTransferId;
    }

    public static void setStockTransferId(String stockTransferId) {
        StockTransfer.stockTransferId = stockTransferId;
    }

    public static String getSecurities() {
        return securities;
    }

    public static void setSecurities(String securities) {
        StockTransfer.securities = securities;
    }

    public static String getSecuritiesCode() {
        return securitiesCode;
    }

    public static void setSecuritiesCode(String securitiesCode) {
        StockTransfer.securitiesCode = securitiesCode;
    }

    public static List<String> getFields() {
        return fields;
    }

    public static void setFields(List<String> fields) {
        StockTransfer.fields = fields;
    }

    public static String getNoKtp() {
        return noKtp;
    }

    public static void setNoKtp(String noKtp) {
        StockTransfer.noKtp = noKtp;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        StockTransfer.address = address;
    }
    public static String getNoIdentityCardKTPOrPassport() {
        return noIdentityCardKTPOrPassport;
    }

    public static void setNoIdentityCardKTPOrPassport(String noIdentityCardKTPOrPassport) {
        StockTransfer.noIdentityCardKTPOrPassport = noIdentityCardKTPOrPassport;
    }

    public static void setData(List<String> fields) {
        setFields(fields);
        for (String field : fields) {
            switch (field) {
                case "Sekuritas Asal":
                case "Nama Nasabah":
                case "No. SID":
                    break;
                case "Kode Nasabah":
                    setCustomerCode("1111111111");
                    break;
                case "No. Sub Rekening Efek":
                    setNoSecuritiesSubAccount("2222222222");
                    break;
                case "No. RDN Sekuritas Asal":
                    setNoRdnOriginalSecurities("33333333333");
                    break;
                case "Alasan Pemindahan":
                    setReasonForTransfer("Just For Testing #" + Data.getRandomNumber());
                    break;
                case "No. KTP":
                    setNoKtp("3102014403910001");
                    break;
                case "Alamat":
                    setAddress("Jakarta pusat pinggie ibukota");
                    break;
                case "No. Kartu Identitas (KTP/Passport)":
                    setNoIdentityCardKTPOrPassport("3102014403910002");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + field);
            }
        }
    }

    public static boolean isEntryPoint() {
        return entryPoint;
    }

    public static void setEntryPoint(boolean entryPoint) {
        StockTransfer.entryPoint = entryPoint;
    }
}
