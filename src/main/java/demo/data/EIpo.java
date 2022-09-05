package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class EIpo {

    private static String eIpoSymbol;
    private static boolean eIpoSection;
    private static boolean visibility;

    public static void setEIpoSymbol(String eIpoSymbol) {
        EIpo.eIpoSymbol = eIpoSymbol;
    }

    public static String getEIpoSymbol() {
        return eIpoSymbol;
    }

    public static void setEIpoSection(boolean eIpoSection) {
        EIpo.eIpoSection = eIpoSection;
    }

    public static boolean getEIpoSection() {
        return eIpoSection;
    }

    public static void setVisibility(boolean visibility) {
        EIpo.visibility = visibility;
    }

    public static boolean getVisibility() {
        return visibility;
    }
}
