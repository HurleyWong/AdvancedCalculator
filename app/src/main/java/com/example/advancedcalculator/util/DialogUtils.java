package com.example.advancedcalculator.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.module.adapter.CurrencyAdapter;
import com.example.advancedcalculator.module.bean.Coin;
import com.example.advancedcalculator.module.bean.Currency;
import com.example.advancedcalculator.module.exchange.ExchangeFragment;
import com.example.advancedcalculator.module.exchange.ExchangePresenter;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/27
 *      github : https://github.com/HurleyJames
 *      desc : Dialog工具类
 * </pre>
 */
public class DialogUtils {
    
    private static final String TAG = "DialogUtils";

    /**
     * 通用带输入框的Dialog的回调接口
     */
    public interface EditDialogListener {
        /**
         * 确定
         * @param dialog
         * @param editText
         */
        void onSummit(Dialog dialog, EditText editText);

        /**
         * 取消
         * @param dialog
         */
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
    public static Dialog showCoinDialog(final Activity activity,
                                        String title,
                                        final TextView tvCoinCode,
                                        final TextView tvCoinName,
                                        CurrencyAdapter adapter,
                                        final List<Coin.ResultBean.ListBean> currencyList,
                                        final TextView tv1,
                                        final TextView tv2,
                                        final TextView tv3,
                                        final TextView tvMoney1,
                                        final TextView tvMoney2,
                                        final TextView tvmoney3,
                                        final int onClickItem) {
        //Dialog主题
        int dialogTheme = R.style.defaultDialogTheme;
        final Dialog showIconDialog = new Dialog(activity, dialogTheme);
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
        adapter.setOnItemClickListener(new CurrencyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //点击事件
                Log.e(TAG, "顺序2");
                tvCoinCode.setText(currencyList.get(position).getCode());
                tvCoinName.setText(currencyList.get(position).getName());
                dismissDialog(showIconDialog);
                Log.e(TAG, "这里传入的item变了吗？" + onClickItem);
                ExchangeFragment.newInstance().getCurrency(tv1, tv2, tv3, tvMoney1, tvMoney2, tvmoney3, onClickItem);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //长点击事件
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
        if (showIconDialog.getOwnerActivity() != null && !showIconDialog.getOwnerActivity().isFinishing()) {
            showIconDialog.show();
        }
        
        return showIconDialog;
    }

    /**
     * 警告Dialog
     * @param activity
     * @param title             标题
     * @param content           内容
     */
    public static void showAlertDialog(Activity activity,
                                       String title,
                                       String content) {
        final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        //设置Dialog标题
        alertDialog.setTitle(title);
        //设置Dialog内容
        alertDialog.setMessage(content);
        //设置按钮
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //关闭Dialog
                dismissDialog(alertDialog);
            }
        });

        //显示Dialog
        alertDialog.show();
    }

    /**
     * 关闭Dialog
     * @param dialog
     */
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
