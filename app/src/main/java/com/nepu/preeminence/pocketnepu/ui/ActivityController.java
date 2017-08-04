package com.nepu.preeminence.pocketnepu.ui;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * activity控制类
 * 关闭所有activity
 */

public class ActivityController {

    private static List<AppCompatActivity> activities = new ArrayList<>();

    public static void add(AppCompatActivity activity){
        activities.add(activity);
    }

    public static void remove(AppCompatActivity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (AppCompatActivity activity : activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
