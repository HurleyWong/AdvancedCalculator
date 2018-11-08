package com.example.advancedcalculator.http;

import java.io.IOException;

import okhttp3.Request;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/30
 * </pre>
 */
public abstract class ResultCallback {
    //请求失败
    public abstract void onError(Request request, Exception e);

    //请求成功
    public abstract void onResponse(String str) throws IOException;
}
