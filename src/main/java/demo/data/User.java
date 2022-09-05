package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class User {

    private static String token;
    private static String user;
    private static String username;
    private static String password;
    private static String securitiesToken;
    private static String tradingToken;
    private static String fullname;

    private static String account;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        User.token = "Bearer " + token;
    }

    public static void setUser(String user) {
        User.user = user;
    }

    public static String getUser() {
        return user;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getPassword() {
        return password;
    }

    public static void setSecuritiesToken(String securitiesToken) {
        User.securitiesToken = securitiesToken;
    }

    public static String getSecuritiesToken() {
        return securitiesToken;
    }

    public static void setTradingToken(String tradingToken) {
        User.tradingToken = "Bearer " + tradingToken;
    }

    public static String getTradingToken() {
        return tradingToken;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        User.fullname = fullname;
    }

    public static void setAccount(String pin) {
        User.account = pin;
    }

    public static String getAccount() {
        return account;
    }
}
