package com.example.advancedcalculator.util;

import android.content.Context;
import android.os.Vibrator;

public class VibrateUtils {
    private static final String TAG = "VibrateUtils";

    private static Vibrator mVibrator;

    private static VibrateUtils newInstance() {
        return new VibrateUtils();
    }

    /**
     * 开启震动
     * @param context       调用震动的Context
     * @param millSecond    震动时长，毫秒
     */
    @SuppressWarnings("static-access")
    public static void startVibrate(Context context, int millSecond) {
        mVibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        mVibrator.vibrate(millSecond);
    }

    //停止震动
    public static void stopVibrate() {
        if (mVibrator != null) {
            mVibrator.cancel();
        }
    }
}
