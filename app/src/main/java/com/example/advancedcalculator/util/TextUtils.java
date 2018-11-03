package com.example.advancedcalculator.util;

import java.text.DecimalFormat;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/26
 * </pre>
 */
public class TextUtils {
    
    //保留两位小数
    public static double saveFourDecimal(double num) {
        DecimalFormat df = new DecimalFormat("#.0000");
        return Double.valueOf(df.format(num));
    }
    
    //判断有几位小数
    public static int howManyDecimal(double num) {
        int pos = String.valueOf(num).length() - String.valueOf(num).indexOf(".") - 1;
        return pos;
    }
}
