package com.example.advancedcalculator.app;

import android.app.Activity;
import android.app.Application;

import com.example.advancedcalculator.util.AppUtils;

import java.util.ArrayList;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/11/07
 *      desc   : Applicaiton基类
 * </pre>
 */

public abstract class BaseApplication extends Application {
    protected static BaseApplication instance;
    protected ArrayList<Activity> mActivityList;
    
    public static BaseApplication getInstance() {
        return instance;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (inMainProcess()) {
            mActivityList = new ArrayList<>();
        }
    }
    
    protected boolean inMainProcess() {
        String packageName = getPackageName();
        String processName = AppUtils.getProcessName(this);
        return packageName.equals(processName);
    }

    public void finishAllActivity() {
        if (mActivityList != null) {
            for (Activity activity : mActivityList) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            mActivityList.clear();
        }
    }

    /**
     * 关闭所有Activity
     */
    public void exit() {
        finishAllActivity();
    }

    /**
     * 获取当前Activity
     * @return
     */
    public Activity getCurrentActivity() {
        if (mActivityList != null && mActivityList.size() > 0) {
            return mActivityList.get(mActivityList.size() - 1);
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
