package com.example.advancedcalculator.module.exchange;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedcalculator.R;
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
 *      @author hurley
 *      date : 2018/10/23
 *      github : https://github.com/HurleyJames
 *      desc :
 * </pre>
 */
public class ExchangePresenter extends BasePresenter implements ExchangeContract.Presenter {
    private static final String TAG = "ExchangePresenter";

    public static ExchangePresenter newInstance() {
        return new ExchangePresenter();
    }

    /**
     * 从网络获取实时汇率
     *
     * @param url
     * @return
     */
    public List getCurrencyFromNet(String url, final List<String> mCurrencyList) {
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
                final Currency currency = GsonUtils.getObject(str, Currency.class);
                for (int i = 0; i < currency.getResult().size(); i++) {
                    mCurrencyList.add(currency.getResult().get(i).getResult());
                    Log.e(TAG, mCurrencyList.get(i));
                }
            }
        });
        return mCurrencyList;
    }


    /**
     * 从网络获取数据
     *
     * @param url      获取货币的url
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
                final Coin coin = GsonUtils.getObject(str, Coin.class);
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
     *
     * @param coinList
     * @param context
     * @return
     */
    public List getCoinFromLocal(final List<Coin.ResultBean.ListBean> coinList, Context context) {
        String jsonContext = FileUtils.readFileFromAssets("coin.json", context);
        final Coin coin = GsonUtils.getObject(jsonContext, Coin.class);
        for (int i = 0; i < coin.getResult().getList().size(); i++) {
            coinList.add(new Coin.ResultBean.ListBean(coin.getResult().getList().get(i).getName(), coin.getResult().getList().get(i).getCode()));
            Log.d(TAG, coin.getResult().getList().get(i).getName());
        }
        return coinList;
    }

    /**
     * 点击AC，清空所有数据
     * @param tv1
     * @param tv2
     * @param tv3
     */
    public void onClickAC(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setText("0");
        tv2.setText("0");
        tv3.setText("0");
    }

    public boolean isResultRight(Currency currency) {
        if (currency.getError_code() == 10001) {
            Log.e(TAG, "错误的请求KEY");
            return false;
        } else if (currency.getError_code() == 10002) {
            Log.e(TAG, "该KEY无请求权限");
            return false;
        } else if (currency.getError_code() == 10003) {
            Log.e(TAG, "KEY过期");
            return false;
        } else if (currency.getError_code() == 10004) {
            Log.e(TAG, "错误的OPENID");
            return false;
        } else if (currency.getError_code() == 10005) {
            Log.e(TAG, "应用未审核超时，请提交认证");
            return false;
        } else if (currency.getError_code() == 10007) {
            Log.e(TAG, "未知的请求源");
            return false;
        } else if (currency.getError_code() == 10008) {
            Log.e(TAG, "被禁止的IP");
            return false;
        } else if (currency.getError_code() == 10009) {
            Log.e(TAG, "被禁止的KEY");
            return false;
        } else if (currency.getError_code() == 10011) {
            Log.e(TAG, "当前IP请求超过限制");
            return false;
        } else if (currency.getError_code() == 10012) {
            Log.e(TAG, "请求超过次数限制");
            return false;
        } else if (currency.getError_code() == 10013) {
            Log.e(TAG, "测试KEY超过请求限制");
            return false;
        } else if (currency.getError_code() == 10014) {
            Log.e(TAG, "系统内部异常");
            return false;
        } else if (currency.getError_code() == 208001) {
            Log.e(TAG, "货币兑换名称不能为空");
            return false;
        } else if (currency.getError_code() == 208002) {
            Log.e(TAG, "查询不到汇率相关信息");
            return false;
        } else if (currency.getError_code() == 208003) {
            Log.e(TAG, "网络错误，请重试");
            return false;
        } else if (currency.getError_code() == 208004) {
            Log.e(TAG, "查询不到常用货币相关信息");
            return false;
        } else if (currency.getError_code() == 208005) {
            Log.e(TAG, "不存在的货币种类");
            return false;
        } else if (currency.getError_code() == 208006) {
            Log.e(TAG, "查询不到该货币兑换相关信息");
            return false;
        }
        return true;
    }
}
