package android.game.simplecalc.ui;

import android.content.SharedPreferences;
import android.game.simplecalc.R;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity extends AppCompatActivity {


    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";

    // Имя параметра в настройках
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

    // Чтение настроек, параметр тема
    protected int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    // Сохранение настроек
    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
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
