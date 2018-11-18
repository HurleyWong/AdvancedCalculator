package com.example.advancedcalculator.util;

import android.content.Context;
import android.widget.Toast;
/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/07
 *      github : https://github.com/HurleyJames
 *      desc : Toast工具类
 * </pre>
 */
public class ToastUtils {
    private static final String TAG = "ToastUtils";

    /**
     * 短时间Toast
     * @param context
     * @param text
     */
    public static void showShortToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间Toast
     * @param context
     * @param text
     */
    public static void showLongToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示具体时长的Toast
     * @param context
     * @param text
     * @param duration
     */
    public static void showToast(Context context, String text, int duration) {
        Toast.makeText(context, text, duration).show();
    }

    /**
     * 显示具体时长和位置的Toast
     * @param context
     * @param text
     * @param duration
     * @param gravity
     */
    public static void showToast(Context context, String text, int duration, int gravity) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }
}
