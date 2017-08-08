package com.nepu.preeminence.pocketnepu.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.nepu.preeminence.pocketnepu.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity{

    private ViewPager mViePager;
    //ViewPager的容器
    private List<View> mList = new ArrayList<>();

    private View view1,view2,view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


        initView();



    }

    private void initView() {
        mViePager = (ViewPager) findViewById(R.id.vp_welcome);

        view1 = View.inflate(this,R.layout.pager_item_one,null);
        view2 = View.inflate(this,R.layout.pager_item_two,null);
        view3 = View.inflate(this,R.layout.pager_item_three,null);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        mViePager.setAdapter(new GuideAdapter());
    }


    /**
     *
     */
    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }
    }
}
