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
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/31
 * </pre>
 */
public class GsonHelper{
    private static final String TAG="GsonHelper";

    private static GsonHelper helper;

    public static GsonHelper getInstance() {
        if (helper == null) {
            helper = new GsonHelper();
        }
        return helper;
    }

    private GsonHelper() {
        super();
    }

    public String createGsonString(Object value) {
        Gson gson = new Gson();
        String str = gson.toJson(value);
        return str;
    }

    public <T> T getObject(String jsonString, Class<T> clazz) {
        T t = null;
        try{
            if (isJsonRight(jsonString)) {
                Gson gson = new Gson();
                t = gson.fromJson(jsonString, clazz);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public <T> List<T> getList(String jsonString,TypeToken<T> t) {
        List<T> list = new ArrayList<>();
        try{
            if (isJsonRight(jsonString)) {
                Gson gson = new Gson();
                list = gson.fromJson(jsonString, t.getType());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean isJsonWrong(String json) {
        return !isJsonRight(json);
    }

    public boolean isJsonRight(String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        }
        try{
            new JsonParser().parse(json);
        } catch(JsonParseException e) {
            return false;
        }
        return true;
    }
}
















