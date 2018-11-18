package com.example.advancedcalculator.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/23
 *      github : https://github.com/HurleyJames
 *      desc : Activity工具类
 * </pre>
 */
public class ActivityUtils {

    private static final String TAG = "ActivityUtils";

    /**
     * 添加Fragment
     * @param fragmentManager
     * @param fragment
     * @param frameId
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    /**
     * 替换Fragment
     * @param fragmentManager
     * @param fragment
     * @param frameId
     */
    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction().replace(frameId, fragment).commitAllowingStateLoss();
    }

    /**
     * 隐藏并添加Fragment
     * @param fragmentManager
     * @param fromFragment
     * @param toFragment
     * @param frameId
     */
    public static void hideAndAddFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fromFragment, @NonNull Fragment toFragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).add(frameId, toFragment).show(toFragment).commit();
    }

    /**
     * 隐藏并显示Fragment
     * @param fragmentManager
     * @param fromFragment
     * @param toFragment
     */
    public static void hideAndShowFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fromFragment, @NonNull Fragment toFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).show(toFragment).commit();
    }

    /**
     * 隐藏Fragment
     * @param fragmentManager
     * @param fragment
     */
    public static void hideFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment).commit();
    }
}


















