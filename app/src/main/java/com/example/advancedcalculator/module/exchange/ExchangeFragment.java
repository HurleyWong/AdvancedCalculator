package com.example.advancedcalculator.module.exchange;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.base.BaseFragment;
import com.example.advancedcalculator.util.ChangeMoneyUtils;
import com.example.advancedcalculator.util.DialogUtils;
import com.example.advancedcalculator.util.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class ExchangeFragment extends BaseFragment implements ExchangeContract.View{
    private static final String TAG = "ExchangeFragment";

    @BindView(R.id.ll_country)
    LinearLayout mLlCountry;

    @BindView(R.id.img_flag1)
    ImageView mIvFlag1;

    @BindView(R.id.country_title1)
    TextView mTvTitle1;

    @BindView(R.id.country_money1)
    TextView mTvMoney1;

    @BindView(R.id.country_coin_type1)
    TextView mTvCoinType1;

    @BindView(R.id.img_flag2)
    ImageView mIvFlag2;

    @BindView(R.id.country_title2)
    TextView mTvTitle2;

    @BindView(R.id.country_money2)
    TextView mTvMoney2;

    @BindView(R.id.country_coin_type2)
    TextView mTvCoinType2;

    @BindView(R.id.img_flag3)
    ImageView mIvFlag3;

    @BindView(R.id.country_title3)
    TextView mTvTitle3;

    @BindView(R.id.country_money3)
    TextView mTvMoney3;

    @BindView(R.id.country_coin_type3)
    TextView mTvCoinType3;

    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;

    @BindView(R.id.btn_7)
    TextView mTvBtn7;

    @BindView(R.id.btn_4)
    TextView mTvBtn4;

    @BindView(R.id.btn_0)
    TextView mTvBtn0;

    @BindView(R.id.btn_8)
    TextView mTvBtn8;

    @BindView(R.id.btn_5)
    TextView mTvBtn5;

    @BindView(R.id.btn_2)
    TextView mTvBtn2;

    @BindView(R.id.btn_empty)
    TextView mTvBtnEmpty;

    @BindView(R.id.btn_9)
    TextView mTvBtn9;

    @BindView(R.id.btn_6)
    TextView mTvBtn6;

    @BindView(R.id.btn_3)
    TextView mTvBtn3;

    @BindView(R.id.btn_point)
    TextView mTvBtnPoint;

    @BindView(R.id.btn_AC)
    TextView mTvBtnAC;

    @BindView(R.id.btn_del)
    TextView mTvBtnDel;

    @BindView(R.id.divide_vertical1)
    View mViewDivide;


    private StringBuffer mMoney = new StringBuffer("");

    //汇率
    private double rate;

    //是否可添加
    private boolean isAdd = true;





    private ExchangeContract.Presenter mPresenter;

    public static ExchangeFragment newInstance() {
        return new ExchangeFragment();
    }

    @Override
    public int getLayoutId(){
        return R.layout.fragment_exchange_rate;
    }

    @Override
    public void initViews(){

    }

    @Override
    public void setPresenter(ExchangeContract.Presenter presenter){
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, root);
        //设置第一列的竖直分割线的高度


        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9, R.id.btn_point, R.id.btn_AC, R.id.btn_del})
    public void onClicktNum(TextView textView) {
        Log.e(TAG, mMoney.toString() + "长度：" + mMoney.length());
        switch(textView.getId()) {
            case R.id.btn_AC:
                //清空StringBuffer
                mMoney.delete(0,mMoney.length());
                mMoney = new StringBuffer("");
                //AC清空后又可以重新输入数据
                isAdd = true;
                break;
            case R.id.btn_del:
                mMoney.deleteCharAt(mMoney.length() - 1);
                break;
        }
        if (isAdd) {
            switch(textView.getId()) {
                case R.id.btn_0:
                    //如果长度大于0且首位不为0
                    if (mMoney.length() > 0 && mMoney.charAt(0) != '0'){
                        mMoney.append("0");
                        Log.d(TAG, "点击0");
                    }
                    break;
                case R.id.btn_1:
                    mMoney.append("1");
                    break;
                case R.id.btn_2:
                    mMoney.append("2");
                    break;
                case R.id.btn_3:
                    mMoney.append("3");
                    break;
                case R.id.btn_4:
                    mMoney.append("4");
                    break;
                case R.id.btn_5:
                    mMoney.append("5");
                    break;
                case R.id.btn_6:
                    mMoney.append("6");
                    break;
                case R.id.btn_7:
                    mMoney.append("7");
                    break;
                case R.id.btn_8:
                    mMoney.append("8");
                    break;
                case R.id.btn_9:
                    mMoney.append("9");
                    break;
                case R.id.btn_point:
                    //如果已经含有小数点，则再点击没用
                    if (!mMoney.toString().contains(".")) {
                        mMoney.append(".");
                    }
                    break;
            }
        }
        if (mMoney.equals("") || mMoney.length() == 0) {
            mTvMoney1.setText("0");
            mTvMoney2.setText("0");
            mTvMoney3.setText("0");
        }
        else {
            double money1 = Double.parseDouble(mMoney.toString());
            //判断money1
            if (TextUtils.howManyDecimal(money1) <= 4) {
                mTvMoney1.setText(mMoney);
            } else {
                //超过4位小数，不可再添加数字
                isAdd = false;
            }

            double money2 = ChangeMoneyUtils.showExchangedMoney(money1, 0.3);
            //判断money2
            //如果小数不多于4
            if (TextUtils.howManyDecimal(money2) <= 4) {
                mTvMoney2.setText(String.valueOf(money2));
            } else {
                //保留4位小数
                mTvMoney2.setText(String.valueOf(TextUtils.saveFourDecimal(money2)));
            }

            double money3 = ChangeMoneyUtils.showExchangedMoney(money1, 0.2);
            //判断money3
            if (TextUtils.howManyDecimal(money3) <= 4) {
                mTvMoney3.setText(String.valueOf(money3));
            } else {
                //保留4位小数
                mTvMoney3.setText(String.valueOf(TextUtils.saveFourDecimal(money3)));
            }
        }
    }

    //点击国家弹出选择货币种类Dialog
    @OnClick({R.id.country_title1, R.id.country_title2, R.id.country_title3})
    public void onClickCountry() {
        DialogUtils.showIconDialog(getActivity(), "选择币种");
    }

    //TODO 分割线? 删除图标 api获取汇率 国家 选择国家Dialog!（RecyclerView适配器，间距问题）
    //TODO 直接点击.闪退问题（修改逻辑）

}
