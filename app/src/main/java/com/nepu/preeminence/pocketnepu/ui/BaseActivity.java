package com.nepu.preeminence.pocketnepu.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * 所有aty的基类
 * 1.统一的属性
 * 2.统一的接口
 * 3.统一的方法
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //actionbar显示返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            //返回按钮事件
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
