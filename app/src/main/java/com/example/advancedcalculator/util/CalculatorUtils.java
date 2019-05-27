package com.example.advancedcalculator.util;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/07
 *      github : https://github.com/HurleyJames
 *      desc : 计算器算法工具类
 * </pre>
 */
public class CalculatorUtils {
    private static final String TAG = "CalculatorUtils";

    /**
     * 最大显示长度
     */
    private static int maxLength = 30;

    /**
     * 中缀转后缀
     *
     * @param buffer 表达式
     * @return 返回一个ArrayList对象，即一个后缀表达式
     */
    public static ArrayList Suffix(StringBuffer buffer) {

        /*
         * Stack()  构造方法
         * void add(int index, Object elememt)  在此向量的指定位置插入指定的元素
         * boolean empty()  测试栈顶是否为空
         * Object pop() 移除栈顶的元素，并作为此函数的值返回该对象
         * Object push(Object element)  压入栈顶
         */

        //中间字符串，临时存放数字，方便往list中添加
        StringBuffer temp = new StringBuffer();

        //用于存储分割后的数字和符号
        List<String> list = new ArrayList<>();

        //作为结果集合，后缀表达式保存在里面
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < buffer.length(); i++) {
            //判断是不是数字
            if ((buffer.charAt(i) >= '0' && buffer.charAt(i) <= '9') || buffer.charAt(i) == '.') {
                //如果此位为'.'，且中间字符串为空，自动补0
                if (buffer.charAt(i) == '.' && temp.length() == 0) {
                    //添加0，再添加.
                    temp.append(0);
                    temp.append(buffer.charAt(i));
                } else {
                    //是数字则直接添加
                    temp.append(buffer.charAt(i));
                }
                //对最后一位进行单独判断，如果是字符串最后一位，直接进行添加到list操作
                if (i == buffer.length() - 1) {
                    list.add(temp.toString());
                }
            } else {
                //不是数字
                if (temp.length() != 0) {
                    //判断中间字符串长度是否为0，不为0就直接往list中添加
                    list.add(temp.toString());
                }
                //将符号往list中添加
                list.add(String.valueOf(buffer.charAt(i)));
                //清空中间字符串
                temp.delete(0, temp.length());
            }
        }

        //遍历输出
        for (String aList : list) {
            Log.d(TAG, "遍历输出" + aList);
        }


        //定义栈
        Stack<String> stack = new Stack<>();

        //定义符号的优先级
        Map<Character, Integer> map = new HashMap<>(10);
        map.put('*', 1);
        map.put('÷', 1);
        map.put('%', 1);
        map.put('+', 2);
        map.put('-', 2);

        for (String s : list) {
            //不为数字
            if (s.equals("*") || s.equals("÷") || s.equals("+") || s.equals("-") || s.equals("%")) {
                //如果当前栈为空，则直接入栈
                if (stack.size() == 0) {
                    stack.push(s);
                } else {
                    //如果栈顶符号的优先级高于元素优先级，入栈
                    if (map.get(s.charAt(0)) < map.get(stack.peek().charAt(0))) {
                        stack.push(s);
                    } else {
                        //如果栈顶符号优先级低于元素优先级
                        while ((map.get(s.charAt(0)) >= map.get(stack.peek().charAt(0))) && !stack.empty()) {
                            result.add(stack.pop());
                            if (stack.empty()) {
                                break;
                            }
                        }
                        stack.push(s);
                    }
                }
            } else {
                //是数字
                result.add(s);
            }
        }

        //遍历栈，把结果保存到result中，直到栈被清空
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 用于计算后缀表达式的结果
     *
     * @param arrayList 后缀表达式
     * @return 运算的最终结果
     */
    public static String calculate(ArrayList arrayList) {
        int length = arrayList.size();
        Log.d(TAG, "传过来的长度1：" + length);
        //转化为字符串数组
        String[] arr = new String[length];

        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = (String) arrayList.get(i);
        }
        Log.d(TAG, "传过来的List：" + arrayList.toString());

        List<String> list = new ArrayList<>();

        for (String anArr : arr) {
            int size = list.size();
            Log.d(TAG, "list是啥：" + list.toString());
            Log.d(TAG, "传过来的长度2：" + size);
            switch (anArr) {
                case "+":
                    BigDecimal a = new BigDecimal(list.remove(size - 2)).add(new BigDecimal(list.remove(size - 2)));
                    //去掉结果末尾的0
                    list.add(a.stripTrailingZeros().toString());
                    break;
                case "-":
                    BigDecimal b = new BigDecimal(list.remove(size - 2)).subtract(new BigDecimal(list.remove(size - 2)));
                    list.add(b.stripTrailingZeros().toString());
                    break;
                case "*":
                    BigDecimal c = new BigDecimal(list.remove(size - 2)).multiply(new BigDecimal(list.remove(size - 2)));
                    list.add(c.stripTrailingZeros().toString());
                    break;
                case "÷":
                    BigDecimal d = new BigDecimal(list.remove(size - 2)).divide(new BigDecimal(list.remove(size - 2)),
                            10, BigDecimal.ROUND_HALF_UP);
                    list.add(d.stripTrailingZeros().toString());
                    break;
                default:
                    //如果是数字，直接加入list中
                    list.add(anArr);
                    break;
            }
        }

        if (list.size() == 1) {
            //如果结果长度不长时，直接输出
            if (list.get(0).length() < maxLength) {
                BigDecimal decimal = new BigDecimal(list.get(0));
                //默认直接输出
                Log.e(TAG, "最终结果：" + decimal.toPlainString());
                return decimal.toPlainString();
            } else {
                //如果结果过长时，采用科学计数法输出
                //Double会使用科学计数法输出
                double num = Double.valueOf(list.get(0));
                return String.valueOf(num);
            }
        } else {
            return "运算失败";
        }
    }
}









