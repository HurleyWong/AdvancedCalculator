package com.example.advancedcalculator.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class ActivityUtils{

    //添加Fragment
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    //替换Fragment
    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction()
                .replace(frameId, fragment)
                .commitAllowingStateLoss();
    }

    //隐藏并添加Fragment
    public static void hideAndAddFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                    @NonNull Fragment fromFragment,
                                                    @NonNull Fragment toFragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).add(frameId, toFragment).show(toFragment).commit();
    }

    //隐藏并显示Fragment
    public static void hideAndShowFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                     @NonNull Fragment fromFragment,
                                                     @NonNull Fragment toFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fromFragment).show(toFragment).commit();
    }

    //隐藏Fragment
    public static void hideFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment).commit();
    }
}


















