package com.example.advancedcalculator.module.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.module.adapter.viewholder.CurrencyViewHolder;
import com.example.advancedcalculator.module.bean.Currency;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/30
 * </pre>
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyViewHolder>{

    private static final String TAG="CurrencyAdapter";

    //货币名称
    private List<Currency> mTitleList;
    //货币代码
    private List<Currency> mSubTitleList;
    private Context mContext;

    public CurrencyAdapter(Context mContext, List<Currency> mTitleList, List<Currency> mSubTitleList) {
        this.mContext = mContext;
        this.mTitleList = mTitleList;
        this.mSubTitleList = mSubTitleList;
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        CurrencyViewHolder holder = new CurrencyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_dialog_coin, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder,int position){
        holder.mTvCoinTitle.setText(mTitleList.get(position).getName());
        holder.mTvCoinSubTitle.setText(mSubTitleList.get(position).getCode());
    }

    @Override
    public int getItemCount(){
        return mTitleList.size() > mSubTitleList.size() ? mTitleList.size() : mSubTitleList.size();
    }
}
