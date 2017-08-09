package com.nepu.preeminence.pocketnepu.ui;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nepu.preeminence.pocketnepu.MainActivity;
import com.nepu.preeminence.pocketnepu.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {

    private ViewPager mViePager;
    //ViewPager的容器
    private List<View> mList = new ArrayList<>();

    private View view1, view2, view3;
    private ImageView ivPoint1, ivPoint2, ivPoint3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


        initView();


    }

    private void initView() {
        mViePager = (ViewPager) findViewById(R.id.vp_welcome);
        ivPoint1 = (ImageView) findViewById(R.id.iv_poinit_one);
        ivPoint2 = (ImageView) findViewById(R.id.iv_poinit_two);
        ivPoint3 = (ImageView) findViewById(R.id.iv_poinit_three);


        //设置小圆点默认颜色
        setPointImg(true, false, false);

        //加载三个欢迎页
        view1 = View.inflate(this, R.layout.pager_item_one, null);
        view2 = View.inflate(this, R.layout.pager_item_two, null);
        view3 = View.inflate(this, R.layout.pager_item_three, null);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        mViePager.setAdapter(new GuideAdapter());
        mViePager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 监听滑动事件
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setPointImg(true, false, false);
                        break;
                    case 1:
                        setPointImg(false, true, false);
                        break;
                    case 2:
                        setPointImg(false, false, true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //进入主页按钮
        view3.findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
            }
        });

    }

    /**
     * 设置欢迎页底部小圆点颜色
     *
     * @param isCheck1
     * @param isCheck2
     * @param isCheck3
     */
    private void setPointImg(boolean isCheck1, boolean isCheck2, boolean isCheck3) {
        if (isCheck1) {
            ivPoint1.setImageResource(R.drawable.point_on);
        } else {
            ivPoint1.setImageResource(R.drawable.point_off);
        }

        if (isCheck2) {
            ivPoint2.setImageResource(R.drawable.point_on);
        } else {
            ivPoint2.setImageResource(R.drawable.point_off);
        }

        if (isCheck3) {
            ivPoint3.setImageResource(R.drawable.point_on);
        } else {
            ivPoint3.setImageResource(R.drawable.point_off);
        }

    }


    /**
     *
     */
    class GuideAdapter extends PagerAdapter {

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
