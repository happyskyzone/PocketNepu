package com.nepu.preeminence.pocketnepu.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nepu.preeminence.pocketnepu.MainActivity;
import com.nepu.preeminence.pocketnepu.R;
import com.nepu.preeminence.pocketnepu.utils.ShareUtils;
import com.nepu.preeminence.pocketnepu.utils.StaticClass;
import com.nepu.preeminence.pocketnepu.utils.UtilTools;

import java.util.concurrent.ExecutorService;

public class SplashActivity extends AppCompatActivity {

    private TextView tvSplash;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                //判断程序是否第一次运行
                case StaticClass.HANDLER_SPLASH:
                    if (isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                        finish();
                    }else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                break;
            }
        }
    };

    /**
     * 判断程序是是否第一次运行
     * @return
     */
    private boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST_RUN,true);
        if (isFirst){
            //第一次运行，更改标志位
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST_RUN,false);
            return true;
        }else {
            return false;
        }

    }


    /**
     * 1.延时2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题,在manifest文件中设置
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();



    }


    //初始化View
    private void initView() {
        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tvSplash = (TextView) findViewById(R.id.tv_splash);
        //为欢迎页文字设置字体主题，首先将字体文件放在assets/fonts/FONT.TTF
        UtilTools.setFont(this,tvSplash);
    }


    /**
     * 禁止返回按键
     */
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
