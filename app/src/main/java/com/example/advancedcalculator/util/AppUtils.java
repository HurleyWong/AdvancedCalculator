package com.example.advancedcalculator.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/11/07
 * </pre>
 */
public class AppUtils {
    private static final String TAG = "AppUtils";
    
    /**
     * 获取当前进程名
     * @param context
     * @return  进程名
     */
    public static final String getProcessName(Context context) {
        String processName = null;
    
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        
        while (true) {
            for (ActivityManager.RunningAppProcessInfo info : manager.getRunningAppProcesses()) {
                if (info.pid == android.os.Process.myPid()) {
                    processName = info.processName;
                    break;
                }
            }
            
            if (!TextUtils.isEmpty(processName)) {
                return processName;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
