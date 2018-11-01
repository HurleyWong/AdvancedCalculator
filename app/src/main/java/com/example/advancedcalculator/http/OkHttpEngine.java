package com.example.advancedcalculator.http;

import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/30
 * </pre>
 */

/**
 * 对OkHttp进行封装
 */
public class OkHttpEngine{
    private static final String TAG="OkHttpEngine";

    private static volatile OkHttpEngine mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    public static OkHttpEngine getInstance() {
        if (mInstance == null) {
            synchronized(OkHttpEngine.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpEngine();
                }
            }
        }
        return mInstance;
    }

    private OkHttpEngine() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        mOkHttpClient = builder.build();
        mHandler = new Handler();
    }

    /**
     * 异步GET请求
     * @param url
     * @param callback
     */
    public void getAsynHttp(String url, ResultCallback callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        dealResult(call, callback);
    }

    private void dealResult(Call call,final ResultCallback callback) {
        call.enqueue(new Callback(){
            @Override
            public void onFailure(Call call,IOException e){
                requestError(call.request(), e, callback);
            }

            @Override
            public void onResponse(Call call,Response response) throws IOException{
                requestSuccess(response.body().string(), callback);
            }

            private void requestSuccess(final String str,final ResultCallback callback) {
                mHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        if (callback != null) {
                            try{
                                callback.onResponse(str);
                            } catch(IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }

            private void requestError(final Request request,final Exception e,final ResultCallback back) {
                mHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        if (back != null)
                            back.onError(request, e);
                    }
                });
            }

        });
    }


}






















