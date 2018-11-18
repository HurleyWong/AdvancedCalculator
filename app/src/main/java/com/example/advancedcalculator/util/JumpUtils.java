package com.example.advancedcalculator.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/07
 *      github : https://github.com/HurleyJames
 *      desc : 跳转工具类
 * </pre>
 */
public class JumpUtils {
    private static final String TAG = "JumpUtils";
    
    private static JumpUtils singletion;
    private static Context mContext;
    private static Intent mIntent;

    /**
     * 单例模式
     * @param context
     * @return
     */
    public static JumpUtils from(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null!");
        }
        singletion = new JumpUtils();
        mContext = context;
        return singletion;
    }
    
    public JumpUtils with(Intent intent) {
        if (intent != null) {
            mIntent = intent;
        }
        if (mIntent == null) {
            mIntent = new Intent();
        }
        return singletion;
    }
    
    public void jumpTo(String className) {
        if (mContext == null) {
            return;
        }
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.setComponent(new ComponentName(mContext, className));
        mContext.startActivity(mIntent);
        mIntent = null;
        mContext = null;
        singletion = null;
    }
    
    public void jumpTo(Class<?> clazz) {
        if (mContext == null) {
            return ;
        }
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.setClass(mContext, clazz);
        mContext.startActivity(mIntent);
        mIntent = null;
        mContext = null;
        singletion = null;
    }
}
















