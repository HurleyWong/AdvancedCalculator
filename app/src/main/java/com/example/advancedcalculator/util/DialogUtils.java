package com.example.advancedcalculator.util;

import android.app.Activity;
import android.app.Dialog;
import android.widget.EditText;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class DialogUtils{

    private static final String TAG = "DialogUtils";

    //通用带输入框的Dialog的回调接口
    public interface EditDialogListener {
        void onSummit(Dialog dialog,EditText editText);
        void onCancel(Dialog dialog);
    }

    /**
     * 通用的带输入框的Dialog
     * @param activity
     * @param title
     * @param editString
     * @param editHint
     * @param inputType
     * @param autoDismissDialogOnClick
     * @param listener
     * @return
     */
    public static Dialog showCommonEditDialog(Activity activity,
                                              String title,
                                              String editString,
                                              String editHint,
                                              int inputType,
                                              boolean autoDismissDialogOnClick,
                                              EditDialogListener listener) {
        final Dialog editDialog = new Dialog(activity);
        return editDialog;
    }

    //显示货币的Dialog
    public static Dialog showIconDialog(Activity activity,
                                        String title) {
        final Dialog showIconDialog = new Dialog(activity);
        return showIconDialog;
    }

}
