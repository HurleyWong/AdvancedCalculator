package com.example.advancedcalculator.module.general;

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

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.base.BaseFragment;

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

    private StringBuffer mMoney = new StringBuffer("");

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
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, root);
        return root;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_point, R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply,
            R.id.btn_divide, R.id.btn_percent, R.id.btn_equal, R.id.btn_del, R.id.btn_AC})
    public void onClickNum(View view) {
        Log.e(TAG, mMoney.toString() + "长度：" + mMoney.length());
        switch (view.getId()) {
            case R.id.btn_AC:
                //清空文本内容
                mMoney.delete(0, mMoney.length());
                mMoney = new StringBuffer("");
                break;
            case R.id.btn_0:
                //如果长度大于0且首位不为0
                if (mMoney.length() > 0 && mMoney.charAt(0) != '0') {
                    mMoney.append(0);
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
                //如果不包含.，则可以添加.；如果长度不为0，则可以添加
                if (!mMoney.toString().contains(".")) {
                    if (mMoney.toString().length() == 0)
                        mMoney.append("0");
                    mMoney.append(".");
                }
                break;
            case R.id.btn_del:
                //如果长度不为0，则去掉末尾
                if (mMoney.length() > 0) {
                    mMoney.deleteCharAt(mMoney.length() - 1);
                }
                break;
            case R.id.btn_add:
                deleteLastStr();
                mMoney.append("+");
                break;
            case R.id.btn_subtract:
                deleteLastStr();
                mMoney.append("-");
                break;
            case R.id.btn_multiply:
                deleteLastStr();
                mMoney.append("×");
                break;
            case R.id.btn_divide:
                deleteLastStr();
                mMoney.append("÷");
                break;
            case R.id.btn_percent:
                deleteLastStr();
                mMoney.append("%");
                break;
        }
        if (mMoney.equals("") || mMoney.length() == 0) {
            mTvNum.setText("0");
        } else {
            mTvNum.setText(mMoney);
        }
    }

    //如果StringBuffer的最后一个字符为符号，则去掉
    private void deleteLastStr() {
        //获取算数式的最后一个字符
        String last = mMoney.substring(mMoney.length() - 1);
        //如果前一个字符为符号
        if (last.equals("+") || last.equals("-") || last.equals("×") || last.equals("÷") || last.equals("%")) {
            //去掉末尾的符号
            mMoney.deleteCharAt(mMoney.length() - 1);
        }
    }

}








