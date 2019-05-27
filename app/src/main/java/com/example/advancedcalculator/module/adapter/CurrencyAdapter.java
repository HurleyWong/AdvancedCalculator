package com.example.advancedcalculator.module.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.module.adapter.viewholder.CurrencyViewHolder;
import com.example.advancedcalculator.module.bean.Coin;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/30
 *      github : https://github.com/HurleyJames
 *      desc : 货币适配器类
 * </pre>
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    private static final String TAG = "CurrencyAdapter";

    OnItemClickListener mOnItemClickListener;

    /**
     * 货币
     */
    private List<Coin.ResultBean.ListBean> mCurrencyList;
    private Context mContext;

    public CurrencyAdapter(Context mContext, List<Coin.ResultBean.ListBean> mCurrencyList) {
        this.mContext = mContext;
        this.mCurrencyList = mCurrencyList;
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CurrencyViewHolder holder = new CurrencyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.dialog_coin_recycle_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final CurrencyViewHolder holder, final int position) {
        holder.mTvCoinTitle.setText(mCurrencyList.get(position).getName());
        holder.mTvCoinSubTitle.setText(mCurrencyList.get(position).getCode());


        if (mOnItemClickListener != null) {
            //点击事件
            holder.mRlCoinType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.mRlCoinType, pos);
                }
            });

            //长点击事件
            holder.mRlCoinType.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.mRlCoinType, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCurrencyList.size();
    }


    public interface OnItemClickListener {
        /**
         * RecyclerView点击事件
         *
         * @param view
         * @param position
         */
        void onItemClick(View view, int position);

        /**
         * RecyclerView长点击事件
         *
         * @param view
         * @param position
         */
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
