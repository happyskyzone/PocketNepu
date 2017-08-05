package com.nepu.preeminence.pocketnepu;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nepu.preeminence.pocketnepu.R;
import com.nepu.preeminence.pocketnepu.fragment.ButlerFragment;
import com.nepu.preeminence.pocketnepu.fragment.GirlFragment;
import com.nepu.preeminence.pocketnepu.fragment.UserFragment;
import com.nepu.preeminence.pocketnepu.fragment.WechatFragment;
import com.nepu.preeminence.pocketnepu.ui.BaseActivity;
import com.nepu.preeminence.pocketnepu.ui.SettingActivity;
import com.nepu.preeminence.pocketnepu.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    //所有TabLayout的标题集合
    private List<String> mTitles;
    //所有ViewPager中的Fragment集合
    private List<Fragment> mFragmentList;
    private FloatingActionButton mFabSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //删除Actionbar下部的黑色阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();

        L.d("text");
        L.i("text");
        L.e("text");
        L.w("text");

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
        mFabSettings = (FloatingActionButton) findViewById(R.id.fab_settings);
        mFabSettings.setVisibility(View.GONE);
        mFabSettings.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: "+position);
                //设置ViewPager第一个界面不显示fab_settings
                if (position==0){
                    mFabSettings.setVisibility(View.GONE);
                }else {
                    mFabSettings.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_settings:

                break;
            default:
        }
    }
}
