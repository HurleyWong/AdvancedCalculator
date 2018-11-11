package com.example.advancedcalculator.util;

public class ExchangeUtils {
    private static final String TAG = "ExchangeUtils";


    public static double showExchangedMoney(double money, double rate) {
        return money * rate;
    }

    //获取请求url
    public static String getUrl(String url, String from, String to) {
        url = url + "&from=" + from + "&to=" + to;
        return url;
    }
}
