package demo.data;

import java.util.List;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Watchlist {

    private static String watchlistName;
    private static List<Integer> id;
    private static List<Integer> defaultWatchlistId;

    public static void setWatchlistName(String watchlistName) {
        Watchlist.watchlistName = watchlistName;
    }

    public static String getWatchlistName() {
        return watchlistName;
    }

    public static void setId(List<Integer> id) {
        Watchlist.id = id;
    }

    public static List<Integer> getId() {
        return id;
    }

    public static void setDefaultWatchlistId(List<Integer> defaultWatchlistId) {
        Watchlist.defaultWatchlistId = defaultWatchlistId;
    }

    public static List<Integer> getDefaultWatchlistId() {
        return defaultWatchlistId;
    }
}
