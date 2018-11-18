package com.example.advancedcalculator.util;

import java.text.DecimalFormat;
/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/26
 *      github : https://github.com/HurleyJames
 *      desc : 文本工具类
 * </pre>
 */
public class TextUtils {

    /**
     * 保留两位小数
     * @param num
     * @return
     */
    public static double saveFourDecimal(double num) {
        DecimalFormat df = new DecimalFormat("#.0000");
        return Double.valueOf(df.format(num));
    }

    /**
     * 判断有几位小数
     * @param num
     * @return
     */
    public static int howManyDecimal(double num) {
        int pos = String.valueOf(num).length() - String.valueOf(num).indexOf(".") - 1;
        return pos;
    }
}
