package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class AccountSetting {

    private static String fullName;
    private static String website;
    private static String biography;
    private static String gender;

    public static void setFullName(String fullName) {
        AccountSetting.fullName = fullName;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setWebsite(String website) {
        AccountSetting.website = website;
    }

    public static String getWebsite() {
        return website;
    }

    public static void setBiography(String biografy) {
        AccountSetting.biography = biografy;
    }

    public static String getBiography() {
        return biography;
    }

    public static void setGender(String gender) {
        AccountSetting.gender = gender;
    }

    public static String getGender() {
        return gender;
    }
}
