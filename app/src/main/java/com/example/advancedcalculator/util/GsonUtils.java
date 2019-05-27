package com.example.advancedcalculator.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/31
 *      github : https://github.com/HurleyJames
 *      desc : Gson解析工具类
 * </pre>
 */
public class GsonUtils {
    private static final String TAG = "GsonUtils";

    public static String createGsonString(Object value) {
        Gson gson = new Gson();
        String str = gson.toJson(value);
        return str;
    }

    /**
     * 把json转变成对象
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObject(String jsonString, Class<T> clazz) {
        T t = null;
        try {
            if (isJsonRight(jsonString)) {
                Gson gson = new Gson();
                t = gson.fromJson(jsonString, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * 把json转变成集合
     *
     * @param jsonString
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(String jsonString, TypeToken<T> t) {
        List<T> list = new ArrayList<>();
        try {
            if (isJsonRight(jsonString)) {
                Gson gson = new Gson();
                list = gson.fromJson(jsonString, t.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean isJsonWrong(String json) {
        return !isJsonRight(json);
    }

    public static boolean isJsonRight(String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        }
        try {
            new JsonParser().parse(json);
        } catch (JsonParseException e) {
            return false;
        }
        return true;
    }

}
















