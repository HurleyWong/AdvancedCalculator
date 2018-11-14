package com.example.advancedcalculator.module.relation;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.base.BaseFragment;
import com.example.advancedcalculator.module.bean.Relation;
import com.example.advancedcalculator.widget.SingleLineZoomTextView;

import java.util.ArrayList;
import java.util.List;

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
public class RelationFragment extends BaseFragment implements RelationContract.View {
    private static final String TAG = "RelationFragment";
    
    @BindView(R.id.rl_screen)
    RelativeLayout mRlScreen;
    
    @BindView(R.id.tv_call)
    SingleLineZoomTextView mTvCall;
    
    @BindView(R.id.tv_relation)
    TextView mTvRelation;
    
    @BindView(R.id.ll_keyboard)
    LinearLayout mLlKeyBoard;
    
    @BindView(R.id.btn_husband)
    TextView mTvHusband;
    
    @BindView(R.id.btn_wife)
    TextView mTvWife;
    
    @BindView(R.id.btn_del)
    RelativeLayout mRlDel;
    
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
    
    private StringBuffer mRelation = new StringBuffer("");
    
    private RelationPresenter mPresenter = RelationPresenter.newInstance();
    
    public static RelationFragment newInstance() {
        return new RelationFragment();
    }
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_relationship;
    }
    
    @Override
    public void initViews() {
        mRelation.append(getString(R.string.me));
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,root);
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    
    @OnClick({R.id.btn_husband, R.id.btn_wife, R.id.btn_fathter, R.id.btn_mother,
                R.id.btn_bro1, R.id.btn_bro2, R.id.btn_sister1, R.id.btn_sister2,
                R.id.btn_son, R.id.btn_daughter, R.id.btn_AC, R.id.btn_del})
    public void onClickRelation(View view) {
        String link = getString(R.string.link);
        switch (view.getId()) {
            case R.id.btn_husband:
                mRelation.append(link).append(getString(R.string.husband1));
                break;
            case R.id.btn_wife:
                mRelation.append(link).append(getString(R.string.wife1));
                break;
            case R.id.btn_fathter:
                mRelation.append(link).append(getString(R.string.father));
                break;
            case R.id.btn_mother:
                mRelation.append(link).append(getString(R.string.mother));
                break;
            case R.id.btn_bro1:
                mRelation.append(link).append(getString(R.string.brother1));
                break;
            case R.id.btn_bro2:
                mRelation.append(link).append(getString(R.string.brother2));
                break;
            case R.id.btn_sister1:
                mRelation.append(link).append(getString(R.string.sister1));
                break;
            case R.id.btn_sister2:
                mRelation.append(link).append(getString(R.string.sister2));
                break;
            case R.id.btn_son:
                mRelation.append(link).append(getString(R.string.son));
                break;
            case R.id.btn_daughter:
                mRelation.append(link).append(getString(R.string.daughter));
                break;
            case R.id.btn_AC:
                //清空文本内容
                mRelation.delete(0, mRelation.length());
                mRelation.append("我");
                Log.e(TAG, mRelation.toString());

                //清空称呼
                mTvCall.setText("");
                break;
            case R.id.btn_del:
                //删除
                if (mRelation.length() >= 4) {
                    mRelation.delete(mRelation.length()-3, mRelation.length());
                }
                break;
        }
        
        mTvRelation.setText(mRelation);
    }

    @OnClick(R.id.btn_equal)
    public void onClickEqual() {
        final List<Relation.ResultBean.RelationBean> relationList = new ArrayList<>();
        mPresenter.getRelationByJSON(relationList, getContext());
        if (mRelation.toString().equals("我")) {
            mTvCall.setText("我");
        } else {
            String call = mPresenter.getRelationship(mRelation, relationList);
            Log.e(TAG, "关系：" + mRelation);
            Log.e(TAG, "最终称呼：" + call);

            mTvCall.setText(call);
        }
    }

}
