package ke.co.darkcode.sensei.lilsizeducation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestion;
import ke.co.darkcode.sensei.lilsizeducation.questions.MathQuestions;

/**
 * Created by sensei on 06/07/16.
 */
public class SettingsUtils {
    public static final String PREF_SKIP_WELCOME = "skip_welcome";
    public static final String PREF_WELCOME_SHOWN = "welcome_shown";
    public static final String PREF_MATHS_LEVEL = "maths_level";

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

    public static void setMathsLevel(Context context, int level){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        if (level < 1)
            return;
        if (level > MathQuestions.Companion.getMAX_MATHS_LEVEL())
            return;

        sp.edit().putInt(PREF_MATHS_LEVEL, level);
    }

    public static int getMathsLevel(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return Integer.parseInt(sp.getString(PREF_MATHS_LEVEL, "1"));
    }
}
