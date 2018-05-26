package ru.demo.translator.utils;

import android.app.Activity;
import android.support.annotation.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ru.demo.translator.App;

/**
 * Created by normalteam on 23.04.17.
 */

public class ContextUtill {
    @Nullable
    public static Object GetTopContext() {
        Object topActivity = null;
        try {
            Object o = GetApplicationContext();
            topActivity = ((App) o).getGlobalVarValue();

        } catch (final ClassNotFoundException | NoSuchMethodException | IllegalArgumentException|InvocationTargetException | IllegalAccessException ignored) {
        }
        return topActivity;
    }

    private static Object GetApplicationContext() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final Class<?> activityThreadClass =
                Class.forName("android.app.ActivityThread");
        final Method method = activityThreadClass.getMethod("currentApplication");
        return method.invoke(null, (Object[]) null);
    }

    public static void SetTopContext(Activity activity) {
        ((App) activity.getApplication()).setGlobalVarValue(activity);
    }
}
