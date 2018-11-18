package com.example.advancedcalculator.util;

import android.os.SystemClock;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/13 上午9:22
 *      github : https://github.com/HurleyJames
 *      desc : 点击判断工具类
 * </pre>
 */
public class OnClickUtils {
    private static final String TAG = "OnClickUtils";

    /**
     * 数组的长度为2代表只记录双击操作
     */
    private static final long[] ONCLICK_TIME = new long[2];
    /**
     * 限定间隔时长
     */
    private static final int INTERVAL_TIME = 1500;

    /**
     * 是否在短时间内进行了双击操作
     * @return
     */
    public static boolean isOnDoubleClick() {
        System.arraycopy(ONCLICK_TIME, 1, ONCLICK_TIME, 0, ONCLICK_TIME.length - 1);
        ONCLICK_TIME[ONCLICK_TIME.length - 1] = SystemClock.uptimeMillis();
        if (ONCLICK_TIME[0] >= (SystemClock.uptimeMillis() - INTERVAL_TIME)) {
            return true;
        } else {
            return false;
        }
    }
}
