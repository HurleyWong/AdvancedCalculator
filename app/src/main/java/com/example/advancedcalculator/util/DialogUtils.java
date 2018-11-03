package com.example.advancedcalculator.util;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.module.adapter.CurrencyAdapter;
import com.example.advancedcalculator.module.bean.Currency;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class DialogUtils {
    
    private static final String TAG = "DialogUtils";
    
    //通用带输入框的Dialog的回调接口
    public interface EditDialogListener {
        void onSummit(Dialog dialog, EditText editText);
        
        void onCancel(Dialog dialog);
    }
    
    /**
     * 通用的带输入框的Dialog
     *
     * @param activity
     * @param title
     * @param editString
     * @param editHint
     * @param inputType
     * @param autoDismissDialogOnClick
     * @param listener
     * @return
     */
    public static Dialog showCommonEditDialog(Activity activity, String title, String editString, String editHint, int inputType, boolean autoDismissDialogOnClick, EditDialogListener listener) {
        final Dialog editDialog = new Dialog(activity);
        return editDialog;
    }
    
    /**
     * 显示货币的Dialog
     *
     * @param activity     对应的活动
     * @param title        Dialog的标题
     * @param adapter      Dialog中recyclerview的适配器
     * @param currencyList
     * @return
     */
    public static Dialog showIconDialog(final Activity activity, String title, RecyclerView.Adapter adapter, List<Currency.ResultBean.ListBean> currencyList) {
        //Dialog主题
        int dialogTheme = R.style.defaultDialogTheme;
        final Dialog showIconDialog = new Dialog(activity);
        View contentView = LayoutInflater.from(activity).inflate(R.layout.dialog_coin_type, null);
        showIconDialog.setContentView(contentView);
        //设置Dialog标题
        TextView titleTv = contentView.findViewById(R.id.tv_dialog_title);
        titleTv.setText(title);
        
        //设置Dialog内容
        RecyclerView contentRv = contentView.findViewById(R.id.rv_dialog_content);
        contentRv.setLayoutManager(new LinearLayoutManager(activity));
        contentRv.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
        adapter = new CurrencyAdapter(activity, currencyList);
        contentRv.setAdapter(adapter);
        
        //RecyclerView中item点击事件
        ((CurrencyAdapter) adapter).setOnItemClickListener(new CurrencyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(activity, "1", Toast.LENGTH_LONG).show();
            }
    
            @Override
            public void onItemLongClick(View view, int position) {
        
            }
        });
        
        //点击取消按钮
        TextView cancelTv = contentView.findViewById(R.id.tv_dialog_cancel);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏dialog
                dismissDialog(showIconDialog);
            }
        });
        
        //显示Dialog
        showIconDialog.setOwnerActivity(activity);
        if (showIconDialog.getOwnerActivity() != null && !showIconDialog.getOwnerActivity().isFinishing())
            showIconDialog.show();
        
        return showIconDialog;
    }
    
    //隐藏Dialog
    public static void dismissDialog(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            Activity ownerActivity = dialog.getOwnerActivity();
            if (ownerActivity != null && !ownerActivity.isFinishing()) {
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    //在一些三星手机上dismiss可能出现问题
                    Log.e(TAG, "error dismiss dialog" + e.getMessage());
                }
            }
        }
    }
}
