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
    public abstract void onError(Request request, Exception e);
    
    public abstract void onResponse(String str) throws IOException;
}
