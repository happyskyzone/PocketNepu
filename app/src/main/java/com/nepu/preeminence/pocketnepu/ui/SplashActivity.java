package com.nepu.preeminence.pocketnepu.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nepu.preeminence.pocketnepu.R;

public class SplashActivity extends AppCompatActivity {


    /**
     * 1.延时2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
