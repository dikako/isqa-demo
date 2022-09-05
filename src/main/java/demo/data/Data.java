package demo.data;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.concurrent.ThreadLocalRandom;

/**
 * fransiskusandika 19/01/2022
 */
public class Data {

    private static int maxNumber = 1;
    public static String appIdentifier = "https://stockbit.com/";
    public static final int randomNum = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
    public static final int DEFAULT_SWIPE_DURATION = 15;
    public static int x0;
    public static int x1;
    public static int y0;
    public static int y1;
    public static int x;
    public static int y;
    public static boolean present = false;
    private static boolean maintenanceStatus;
    public static final Dotenv dotenv = Dotenv.load();
    private static boolean refreshPagePopup;
    public static String multipart = "multipart/form-data";
    public static String json = "application/json";
    public static String formUrlEncode = "application/x-www-form-urlencoded; charset=utf-8";
    public static String text = "text/html; charset=UTF-8";

    public static void setMaxNumber(int maxNumber) {
        Data.maxNumber = maxNumber;
    }

    public static int getMaxNumber() {
        return Data.maxNumber;
    }

    public static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
    }

    public static void setX0(int x0) {
        Data.x0 = x0;
    }

    public static void setX1(int x1) {
        Data.x1 = x1;
    }

    public static void setY0(int y0) {
        Data.y0 = y0;
    }

    public static void setY1(int y1) {
        Data.y1 = y1;
    }

    public static void setX(int x) {
        Data.x = x;
    }

    public static void setY(int y) {
        Data.y = y;
    }

    public static void setPresent(boolean present) {
        Data.present = present;
    }

    public static boolean getPresent() {
        return present;
    }

    public static void setMaintenanceStatus(boolean maintenanceStatus) {
        Data.maintenanceStatus = maintenanceStatus;
    }

    public static boolean getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public static String randomString(int digits) {
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder(digits);
        for (int i = 0; i < digits; i++) {
            int index = (int) (alphaNumeric.length() * Math.random());
            stringBuilder.append(alphaNumeric.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static void setRefreshPagePopup(boolean refreshPagePopup) {
        Data.refreshPagePopup = refreshPagePopup;
    }

    public static boolean getRefreshPagePopup() {
        return refreshPagePopup;
    }
}
