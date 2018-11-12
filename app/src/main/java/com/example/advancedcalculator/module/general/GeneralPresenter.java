package com.example.advancedcalculator.module.general;

import android.widget.TextView;

import com.example.advancedcalculator.base.BasePresenter;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class GeneralPresenter extends BasePresenter implements GeneralContract.Presenter {
    private static final String TAG = "GeneralPresenter";

    public static GeneralPresenter newInstance() {
        return new GeneralPresenter();
    }


    //如果StringBuffer的最后一个字符为符号，则去掉
    public void deleteLastStr(StringBuffer buffer) {
        //获取算数式的最后一个字符
        String last = buffer.substring(buffer.length() - 1);
        //如果前一个字符为符号
        if (last.equals("+") || last.equals("-") || last.equals("×") || last.equals("÷") || last.equals("%")) {
            //去掉末尾的符号
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    //如果StringBuffer的最后一个字符是.，则补0
    public void addZeroIfPoint(StringBuffer buffer) {
        String last = buffer.substring(buffer.length() - 1);
        if (last.equals(".")) {
            buffer.append("0");
        }
    }

    public void addZeroIfChar(StringBuffer buffer) {
        String last = buffer.substring(buffer.length() - 1);
        if (last.equals("+") || last.equals("-") || last.equals("×") || last.equals("÷") || last.equals("%")) {
            buffer.append("0");
        }
    }

}