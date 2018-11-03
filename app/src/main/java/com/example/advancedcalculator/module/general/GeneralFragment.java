package com.example.advancedcalculator.module.general;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class GeneralFragment extends BaseFragment implements GeneralContract.View {
    private static final String TAG = "GeneralFragment";
    
    @BindView(R.id.rl_screen)
    RelativeLayout mRlScreen;
    
    @BindView(R.id.tv_num)
    TextView mTvNum;
    
    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;
    
    @BindView(R.id.btn_AC)
    TextView mBtnAC;
    
    @BindView(R.id.btn_7)
    TextView mBtn7;
    
    @BindView(R.id.btn_4)
    TextView mBtn4;
    
    @BindView(R.id.btn_1)
    TextView mBtn1;
    
    @BindView(R.id.btn_del)
    RelativeLayout mBtnDel;
    
    @BindView(R.id.btn_8)
    TextView mBtn8;
    
    @BindView(R.id.btn_5)
    TextView mBtn5;
    
    @BindView(R.id.btn_2)
    TextView mBtn2;
    
    @BindView(R.id.btn_0)
    TextView mBtn0;
    
    @BindView(R.id.btn_divide)
    TextView mBtnDivide;
    
    @BindView(R.id.btn_9)
    TextView mBtn9;
    
    @BindView(R.id.btn_6)
    TextView mBtn6;
    
    @BindView(R.id.btn_3)
    TextView mBtn3;
    
    @BindView(R.id.btn_point)
    TextView mBtnPoint;
    
    @BindView(R.id.btn_multiply)
    TextView mBtnMultiply;
    
    @BindView(R.id.btn_subtract)
    TextView mBtnSub;
    
    @BindView(R.id.btn_add)
    TextView mBtnAdd;
    
    @BindView(R.id.btn_equal)
    TextView mBtnEqual;
    
    private GeneralContract.Presenter mPresenter;
    
    public static final GeneralFragment newInstance() {
        return new GeneralFragment();
    }
    
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_general;
    }
    
    @Override
    public void initViews() {
        ButterKnife.bind(getActivity());
    }
    
    @Override
    public void setPresenter(GeneralContract.Presenter presenter) {
        mPresenter = presenter;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        initViews();
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    
}
