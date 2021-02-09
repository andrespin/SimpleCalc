package android.game.simplecalc.ui;

import android.content.SharedPreferences;
import android.game.simplecalc.R;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity extends AppCompatActivity {


    private static final String NameSharedPreference = "LOGIN";


    private static final String AppTheme = "APP_THEME";

    protected static final int themeSimpleCalc = 0;
    protected static final int themeSimpleCalcNight = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.DayTheme));
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }


    protected int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }


    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case themeSimpleCalc:
                return R.style.DayTheme;
            case themeSimpleCalcNight:
                return R.style.NightTheme;
            default:
                return R.style.DayTheme;
        }
    }
}
