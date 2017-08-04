package com.nepu.preeminence.pocketnepu.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nepu.preeminence.pocketnepu.R;
import com.nepu.preeminence.pocketnepu.fragment.ButlerFragment;
import com.nepu.preeminence.pocketnepu.fragment.GirlFragment;
import com.nepu.preeminence.pocketnepu.fragment.UserFragment;
import com.nepu.preeminence.pocketnepu.fragment.WechatFragment;
import com.nepu.preeminence.pocketnepu.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    //所有TabLayout的标题集合
    private List<String> mTitles;
    //所有ViewPager中的Fragment集合
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //删除Actionbar下部的黑色阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }

    /**
     * 初始化View
     * 1.初始化控件
     * 2.预加载fragment
     * 3.ViewPager设置adapter
     */
    private void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        //预加载,全部加载所有fragment
        mViewPager.setOffscreenPageLimit(mFragmentList.size());

        //为viewPager设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles.get(position);
            }
        });

        //将viewpager绑定到tabLayout
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 初始化数据
     * 1.设置tablayout标题
     * 2.添加Fragment
     */
    private void initData(){
        mTitles = new ArrayList<>();
        mTitles.add("服务管家");
        mTitles.add("微信精选");
        mTitles.add("美女社区");
        mTitles.add("个人中心");

        mFragmentList  = new ArrayList<>();
        mFragmentList.add(new ButlerFragment());
        mFragmentList.add(new WechatFragment());
        mFragmentList.add(new GirlFragment());
        mFragmentList.add(new UserFragment());
    }
}
