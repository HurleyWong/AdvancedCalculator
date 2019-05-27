package com.example.advancedcalculator.util;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/27
 *      github : https://github.com/HurleyJames
 *      desc : 汇率换算工具类
 * </pre>
 */
public class ExchangeUtils {
    private static final String TAG = "ExchangeUtils";


    public static double showExchangedMoney(double money, double rate) {
        return money * rate;
    }

    /**
     * 获取请求url
     *
     * @param url
     * @param from
     * @param to
     * @return
     */
    public static String getUrl(String url, String from, String to) {
        url = url + "&from=" + from + "&to=" + to;
        return url;
    }
}
