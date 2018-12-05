package com.example.advancedcalculator.module;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.advancedcalculator.R;
import com.example.advancedcalculator.adapter.BaseFragmentAdapter;
import com.example.advancedcalculator.module.exchange.ExchangeFragment;
import com.example.advancedcalculator.module.general.GeneralFragment;
import com.example.advancedcalculator.module.relation.RelationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/10/23
 *      github : https://github.com/HurleyJames
 *      desc :
 * </pre>
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        initViewPager();
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.calculator));
        titles.add(getString(R.string.exchange));
        titles.add(getString(R.string.relation));
        
        //为TabLayout设置标题
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GeneralFragment.newInstance());
        fragments.add(ExchangeFragment.newInstance());
        fragments.add(RelationFragment.newInstance());
        
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(adapter);
        //将TabLayout与ViewPager关联起来
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }
    
}
