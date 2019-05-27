package com.example.advancedcalculator.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/27
 *      github : https://github.com/HurleyJames
 *      desc : 屏幕工具类
 * </pre>
 */
public class ScreenUtils {

    private static final String TAG = "ScreenUtils";

    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    /**
     * 获得屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获得屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取屏幕密度
     *
     * @return
     */
    public static float getScreenDensity() {
        DisplayMetrics dm = getDisplayMetrics();
        return dm.density;
    }

    /**
     * 获取控件的高度或宽度
     *
     * @param view
     * @param isHeight
     * @return
     */
    public static int getViewHeightOrWidth(View view, boolean isHeight) {
        int result;
        if (view == null) {
            return 0;
        } else {
            if (isHeight) {
                int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                view.measure(height, 0);
                result = view.getMeasuredHeight();
            } else {
                int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                view.measure(0, width);
                result = view.getMeasuredWidth();
            }
            Log.e(TAG, String.valueOf(result));
            return result;
        }
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}