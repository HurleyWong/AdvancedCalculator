package com.example.advancedcalculator.module.relation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class RelationFragment extends BaseFragment implements RelationContract.View{
    private static final String TAG = "RelationFragment";

    @BindView(R.id.rl_screen)
    RelativeLayout mRlScreen;

    @BindView(R.id.tv_call)
    TextView mTvCall;

    @BindView(R.id.tv_relation)
    TextView mTvRelation;

    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;

    @BindView(R.id.btn_husband)
    TextView mTvHusband;

    @BindView(R.id.btn_wife)
    TextView mTvWife;

    @BindView(R.id.btn_del)
    ImageView mIvDel;

    @BindView(R.id.btn_AC)
    TextView mTvAC;

    @BindView(R.id.btn_fathter)
    TextView mTvFather;

    @BindView(R.id.btn_mother)
    TextView mTvMother;

    @BindView(R.id.btn_bro1)
    TextView mTvBro1;

    @BindView(R.id.btn_bro2)
    TextView mTvBro2;

    @BindView(R.id.btn_sister1)
    TextView mTvSister1;

    @BindView(R.id.btn_sister2)
    TextView mTvSister2;

    @BindView(R.id.btn_son)
    TextView mTvSon;

    @BindView(R.id.btn_daughter)
    TextView mTvDaughter;

    @BindView(R.id.btn_each_other)
    TextView mTvEachOther;

    @BindView(R.id.btn_equal)
    TextView mTvEqual;

    private RelationContract.Presenter mPresenter;

    public static RelationFragment newInstance(){
        return new RelationFragment();
    }

    @Override
    public int getLayoutId(){
        return R.layout.fragment_relationship;
    }

    @Override
    public void initViews(){
        ButterKnife.bind(getActivity());
    }

    @Override
    public void setPresenter(RelationContract.Presenter presenter){
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        initViews();
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
