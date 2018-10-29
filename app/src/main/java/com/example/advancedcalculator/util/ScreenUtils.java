package com.example.advancedcalculator.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class ScreenUtils{

    private static final String TAG = "ScreenUtils";

    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    //获得屏幕宽度
    public static int getScreenWidth() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.widthPixels;
    }

    //获得屏幕高度
    public static int getScreenHeight() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.heightPixels;
    }

    //获取屏幕密度
    public static float getScreenDensity() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.density;
    }

    //设置分割线高度
    /*
    public static void setDivideHeight(View view) {
        view.getLayoutParams().height = getScreenHeight() * 3 / 8;
        Log.e(TAG, "百分比：" + String.valueOf(view.getLayoutParams().height));

    }*/
}
