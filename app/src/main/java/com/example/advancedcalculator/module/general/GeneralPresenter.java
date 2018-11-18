package com.example.advancedcalculator.module.general;

import android.util.Log;

import com.example.advancedcalculator.base.BasePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if (last.equals("+") || last.equals("-") || last.equals("*") || last.equals("÷")) {
            //去掉末尾的符号
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    //判断是否能添加.
    public boolean isAddPointOrNot(StringBuffer buffer) {
        String str = buffer.toString();
        //如果StringBuffer中含有符号
        if (str.contains("+") || str.contains("-") || str.contains("*") || str.contains("÷")) {
            List<Integer> positions = new ArrayList<Integer>();
            int lastIndex1 = str.lastIndexOf("+");
            int lastIndex2 = str.lastIndexOf("-");
            int lastIndex3 = str.lastIndexOf("*");
            int lastIndex4 = str.lastIndexOf("÷");
            positions.add(lastIndex1);
            positions.add(lastIndex2);
            positions.add(lastIndex3);
            positions.add(lastIndex4);
            //获得最后一个符号所在位置
            int lastIndexChar = Collections.max(positions);
            String lastStr = str.substring(lastIndexChar + 1, str.length());
            Log.e(TAG, "最后一个符号所在位置：" + lastIndexChar + " 最后的字符串：" + lastStr);
            if (lastStr.contains(".")) {
                return false;
            } else {
                return true;
            }
        } else {
            //如果StringBuffer中含有.
            if (str.contains(".")) {
                return false;
            } else {
                return true;
            }
        }
    }

    //如果StringBuffer的最后一个字符是.，则补0
    public void addZeroIfPoint(StringBuffer buffer) {
        String last = buffer.substring(buffer.length() - 1);
        if (last.equals(".")) {
            buffer.append("0");
        }
    }

    //如果StringBuffer的最后一个字符是符号，则补0
    public void addZeroIfChar(StringBuffer buffer) {
        String last = buffer.substring(buffer.length() - 1);
        if (last.equals("+") || last.equals("-") || last.equals("*") || last.equals("÷")) {
            buffer.append("0");
        }
    }

    //如果StringBuffer的最后一个字符是符号，则根据不同的符号进行不同的操作
    public void changeIfLastIsChar(StringBuffer buffer) {
        String last = buffer.substring(buffer.length() - 1);
        //如果最后一位是+号或-号
        if (last.equals("+") || last.equals("-")) {
            buffer.append("0");
        }
        //如果最后一位是*号或÷号
        else if (last.equals("*") || last.equals("÷")) {
            buffer.append("1");
        }
    }


    //替换乘号*为x
    public StringBuffer replaceMultiply(StringBuffer buffer, String s1, String s2) {
        //如果StringBuffer中含有某个字符
        if (buffer.toString().contains(s1)) {
            StringBuffer temp = new StringBuffer();
            temp.append(buffer.toString().replace(s1, s2));
            buffer = temp;
        }
        return buffer;
    }

    //获得最后的数字
    public String getLastNum(StringBuffer buffer) {
        String strBuffer = buffer.toString();
        //如果StringBuffer中包含符号
        if (strBuffer.contains("+") || strBuffer.contains("-") || strBuffer.contains("*") || strBuffer.contains("÷")) {
            List<Integer> positions = new ArrayList<Integer>();
            int lastIndex1 = strBuffer.lastIndexOf("+");
            int lastIndex2 = strBuffer.lastIndexOf("-");
            int lastIndex3 = strBuffer.lastIndexOf("*");
            int lastIndex4 = strBuffer.lastIndexOf("÷");
            positions.add(lastIndex1);
            positions.add(lastIndex2);
            positions.add(lastIndex3);
            positions.add(lastIndex4);
            //获得最后一个符号所在位置
            int lastIndexChar = Collections.max(positions);
            return strBuffer.substring(lastIndexChar + 1, strBuffer.length());
        } else {
            return strBuffer;
        }
    }

    //删除最后的数字
    public String deleteLastNum(StringBuffer buffer) {
        String strBuffer = buffer.toString();
        //如果StringBuffer中包含符号
        if (strBuffer.contains("+") || strBuffer.contains("-") || strBuffer.contains("*") || strBuffer.contains("÷")) {
            List<Integer> positions = new ArrayList<Integer>();
            int lastIndex1 = strBuffer.lastIndexOf("+");
            int lastIndex2 = strBuffer.lastIndexOf("-");
            int lastIndex3 = strBuffer.lastIndexOf("*");
            int lastIndex4 = strBuffer.lastIndexOf("÷");
            positions.add(lastIndex1);
            positions.add(lastIndex2);
            positions.add(lastIndex3);
            positions.add(lastIndex4);
            //获得最后一个符号所在位置
            int lastIndexChar = Collections.max(positions);
            return buffer.delete(lastIndexChar + 1, strBuffer.length()).toString();
        } else {
            return buffer.delete(0, buffer.length()).toString();
        }
    }
}