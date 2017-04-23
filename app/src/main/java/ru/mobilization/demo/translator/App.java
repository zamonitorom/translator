package ru.mobilization.demo.translator;

import android.app.Application;

/**
 * Created by normalteam on 22.04.17.
 */

public class App extends Application{

    private Object topActivity;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Object getGlobalVarValue() {
        return topActivity;
    }

    public void setGlobalVarValue(Object value) {
        topActivity = value;
    }
}
