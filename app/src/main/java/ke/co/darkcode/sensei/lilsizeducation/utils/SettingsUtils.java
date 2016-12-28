package ke.co.darkcode.sensei.lilsizeducation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by sensei on 06/07/16.
 */
public class SettingsUtils {
    public static final String PREF_SKIP_WELCOME = "skip_welcome";
    public static final String PREF_WELCOME_SHOWN = "welcome_shown";

    public static boolean isWelcomeSkipped(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_SKIP_WELCOME, false);
    }

    public static void markWelcomeSkipped(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_SKIP_WELCOME, true);
    }

    public static boolean isWelcomeShown(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_WELCOME_SHOWN, false);
    }

    public static void markWelcomeShown(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_WELCOME_SHOWN, true);
    }
}
