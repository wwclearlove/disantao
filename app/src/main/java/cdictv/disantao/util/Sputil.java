package cdictv.disantao.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import cdictv.disantao.App;

public class Sputil {
    private static SharedPreferences sPreferences;

    private static SharedPreferences getPreferences() {
        if (sPreferences == null) {
            sPreferences = PreferenceManager.getDefaultSharedPreferences(App.INSTANSE);
        }
        return sPreferences;
    }

    public static void putString(String key, String value) {
        getPreferences().edit().putString(key, value).apply();
    }

    public static void putBoolean(String key, Boolean value) {
        getPreferences().edit().putBoolean(key, value).apply();
    }

    public static void putInt(String key, Integer value) {
        getPreferences().edit().putInt(key, value).apply();
    }

    public static void removeKey(String key) {
        getPreferences().edit().remove(key).apply();
    }

    public static String getString(String key, String defValue) {
        return getPreferences().getString(key, defValue);

    }


    public static Boolean getBoolean(String key, Boolean def) {
        return getPreferences().getBoolean(key, def);
    }

    public static Integer getIntenger(String key, Integer def) {
        return getPreferences().getInt(key, def);
    }

}
