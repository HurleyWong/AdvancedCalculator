package com.example.advancedcalculator.module.exchange;

import android.content.Context;
import android.util.Log;

import com.example.advancedcalculator.base.BasePresenter;
import com.example.advancedcalculator.http.OkHttpEngine;
import com.example.advancedcalculator.http.ResultCallback;
import com.example.advancedcalculator.module.bean.Coin;
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
    
    public List getCurrencyFromNet(String url, final List<Currency.ResultBean> currencyList) {
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
                for (int i = 0; i < currency.getResult().size(); i ++) {
                    currencyList.add(new Currency.ResultBean(currency.getResult().get(0).getExchange()));
                }
                currencyList.get(0).getExchange();
            }
        });
        return currencyList;
    }
    
    /**
     * 从网络获取数据
     * @param url          获取货币的url
     * @param coinList
     * @return
     */
    public List getCoinFromNet(String url, final List<Coin.ResultBean.ListBean> coinList) {
        
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
                final Coin coin = GsonUtils.getInstance().getObject(str, Coin.class);
                for (int i = 0; i < coin.getResult().getList().size(); i++) {
                    coinList.add(new Coin.ResultBean.ListBean(coin.getResult().getList().get(i).getName(), coin.getResult().getList().get(i).getCode()));
                    Log.e(TAG, coin.getResult().getList().get(i).getName());
                }
            }
        });
        
        return coinList;
    }
    
    /**
     * 从本地读取数据
     * @param coinList
     * @param context
     * @return
     */
    public List getCoinFromLocal(final List<Coin.ResultBean.ListBean> coinList, Context context) {
        String jsonContext = FileUtils.readFileFromAssets("icon.json", context);
        final Coin currency = GsonUtils.getInstance().getObject(jsonContext, Coin.class);
        Log.e(TAG, currency.getResult().getList().get(0).getCode());
        for (int i = 0; i < currency.getResult().getList().size(); i++) {
            coinList.add(new Coin.ResultBean.ListBean(currency.getResult().getList().get(i).getName(), currency.getResult().getList().get(i).getCode()));
            Log.e(TAG, currency.getResult().getList().get(i).getName());
        }
        return coinList;
    }
    
}
