package com.example.advancedcalculator.module.exchange;

import android.util.Log;

import com.example.advancedcalculator.base.BasePresenter;
import com.example.advancedcalculator.http.OkHttpEngine;
import com.example.advancedcalculator.http.ResultCallback;
import com.example.advancedcalculator.module.bean.Currency;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class ExchangePresenter extends BasePresenter implements ExchangeContract.Presenter{
    private static final String TAG = "ExchangePresenter";

    private ExchangeContract.View mView;

    public static ExchangePresenter newInstance() {
        return new ExchangePresenter();
    }

    public void getData(String url) {
        OkHttpEngine.getInstance().getAsynHttp(url,new ResultCallback(){
            @Override
            public void onError(Request request,Exception e){

            }

            @Override
            public void onResponse(String str) throws IOException{
                Log.e(TAG, str);
                Log.e(TAG, "! " + new Gson().fromJson(str,Currency.class).getName());
            }
        });
    }

    //TODO 封装Gson
}
