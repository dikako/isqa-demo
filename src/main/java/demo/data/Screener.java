package demo.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Screener {

    private static String screenName;
    private static String favorite;
    private static List<Integer> id;
    private static List<String> type;
    private static List<String> idTemplate;

    public static void setScreenName(String screenName) {
        Screener.screenName = screenName;
    }

    public static String getScreenName() {
        return screenName;
    }

    public static void setFavorite(String screenerPresetFavorite) {
        Screener.favorite = screenerPresetFavorite;
    }

    public static String getFavorite() {
        return favorite;
    }

    public static void setId(List<Integer> id) {
        Screener.id = id;
    }

    public static List<Integer> getId() {
        return id;
    }

    public static void setType(List<String> type) {
        Screener.type = type;
    }

    public static List<String> getType() {
        return type;
    }

    public static void setIdTemplate(List<String> idTemplate) {
        Screener.idTemplate = idTemplate;
    }

    public static List<String> getIdTemplate() {
        return idTemplate;
    }

    public static List<String> getIdScreener() {
        ArrayList<String> id = new ArrayList<>();
        id.add("5");
        id.add("10");
        id.add("13");
        id.add("76");
        id.add("14");
        id.add("15");
        id.add("20");
        id.add("7");
        id.add("9");
        id.add("74");
        id.add("6");
        id.add("17");
        return id;
    }

    public static List<String> getTypeScreener() {
        ArrayList<String> type = new ArrayList<>();
        for (int i = 0; i < getIdScreener().size(); i++) {
            type.add("TEMPLATE_TYPE_GURU");
        }
        return type;
    }
}
