package com.example.advancedcalculator.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class ScreenUtils {
    
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
    
    //获取控件的高度或宽度
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
    
    //获取最顶层的View
    //public static void
}