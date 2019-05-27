package com.example.advancedcalculator.util;

import android.content.Context;
import android.os.Vibrator;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/31
 *      github : https://github.com/HurleyJames
 *      desc : 震动工具类
 * </pre>
 */
public class VibrateUtils {
    private static final String TAG = "VibrateUtils";

    private static Vibrator sVibrator;

    /**
     * 开启震动
     *
     * @param context    调用震动的Context
     * @param millSecond 震动时长，毫秒
     */
    @SuppressWarnings("static-access")
    public static void startVibrate(Context context, int millSecond) {
        sVibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        sVibrator.vibrate(millSecond);
    }

    /**
     * 停止震动
     */
    public static void stopVibrate() {
        if (sVibrator != null) {
            sVibrator.cancel();
        }
    }
}
