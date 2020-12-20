package com.example.final_syfler;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class fat extends Application {

    //инициализация приложения
    @Override
    public void onCreate() {
        super.onCreate();
        int size_coef;
        final float start_value = 0.7f; //начальное значение размера шрифта
        final float step = 0.15f; //шаг увеличения коэффициента
        Resources res = getResources();
        SharedPreferences settings = getSharedPreferences("MyAppSett", MODE_PRIVATE);
        try {
            //считываем коэффициент размера шрифта
            size_coef = settings.getInt("size_coef", 2);
        }
        catch (Exception e) {
            size_coef = 2; //коэффициент по умолчанию
        }

        //новый коэффициент увеличения шрифта
        float new_value = start_value + size_coef * step;
        //устанавливаем размер шрифта в приложении
        Configuration configuration = new Configuration(res.getConfiguration());
        configuration.fontScale = new_value;
        res.updateConfiguration(configuration, res.getDisplayMetrics());
    }
}