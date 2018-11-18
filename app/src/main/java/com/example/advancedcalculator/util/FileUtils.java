package com.example.advancedcalculator.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/04
 *      github : https://github.com/HurleyJames
 *      desc : 文件工具类
 * </pre>
 */
public class FileUtils {
    private static final String TAG = "FileUtils";

    /**
     * 读取位于assets文件夹中的文件并转换成字符串
     * @param fileName
     * @param context
     * @return
     */
    public static String readFileFromAssets(String fileName, Context context) {
        StringBuilder builder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager manager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    manager.open(fileName)
            ));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
