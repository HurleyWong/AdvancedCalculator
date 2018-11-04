package com.example.advancedcalculator.module.exchange;

import android.content.Context;
import android.util.Log;

import com.example.advancedcalculator.base.BasePresenter;
import com.example.advancedcalculator.http.OkHttpEngine;
import com.example.advancedcalculator.http.ResultCallback;
import com.example.advancedcalculator.module.bean.Currency;
import com.example.advancedcalculator.util.FileUtils;
import com.example.advancedcalculator.util.GsonUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class ExchangePresenter extends BasePresenter implements ExchangeContract.Presenter {
    private static final String TAG = "ExchangePresenter";
    
    private ExchangeContract.View mView;
    
    public static ExchangePresenter newInstance() {
        return new ExchangePresenter();
    }
    
    /**
     * 从网络获取数据
     * @param url          获取货币的url
     * @param currencyList
     * @return
     */
    public List getDataFromNet(String url, final List<Currency.ResultBean.ListBean> currencyList) {
        
        OkHttpEngine.getInstance().getAsynHttp(url, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                //获取请求失败
            }
            
            @Override
            public void onResponse(String str) throws IOException {
                //获取请求成功
                Log.e(TAG, str);
                //把json转变成对象
                final Currency currency = GsonUtils.getInstance().getObject(str, Currency.class);
                for (int i = 0; i < currency.getResult().getList().size(); i++) {
                    currencyList.add(new Currency.ResultBean.ListBean(currency.getResult().getList().get(i).getName(), currency.getResult().getList().get(i).getCode()));
                    Log.e(TAG, currency.getResult().getList().get(i).getName());
                }
            }
        });
        
        return currencyList;
    }
    
    /**
     * 从本地读取数据
     * @param currencyList
     * @param context
     * @return
     */
    public List getDataFromLocal(final List<Currency.ResultBean.ListBean> currencyList, Context context) {
        String jsonContext = FileUtils.readFileFromAssets("icon.json", context);
        final Currency currency = GsonUtils.getInstance().getObject(jsonContext, Currency.class);
        for (int i = 0; i < currency.getResult().getList().size(); i++) {
            currencyList.add(new Currency.ResultBean.ListBean(currency.getResult().getList().get(i).getName(), currency.getResult().getList().get(i).getCode()));
            Log.e(TAG, currency.getResult().getList().get(i).getName());
        }
        return currencyList;
    }
    
}
