package com.nepu.preeminence.pocketnepu.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nepu.preeminence.pocketnepu.R;

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
        ActivityController.add(this);
//        //actionbar显示返回按钮
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.remove(this);
    }

    /**
     * 初始化菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.m_app_exit:
                //关闭所有activity
                ActivityController.finishAll();
                break;
            case android.R.id.home:
                //ActionBar中左上角返回按键事件
                finish();
            default:
        }
        return true;
    }
}
