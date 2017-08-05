package com.nepu.preeminence.pocketnepu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Preeminence on 2017/8/4.
 */

public class shareUtils {
    public static  final String NAME = "config";

    /**
     * SharedPreferences存储字符串数据
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context,String key,String value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    /**
     * 从SharedPreferences去出字符串
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(Context context,String key,String defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }


    /**
     * SharedPreferences存储整形数据
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context,String key,int value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }

    /**
     * 从SharedPreferences去出整形
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(Context context,String key,int defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }

    /**
     * SharedPreferences存储boolean数据
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context,String key,Boolean value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }

    /**
     * 从SharedPreferences去出boolean
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    /**
     * 删除单个数据
     * @param context
     * @param key
     */
    public static void deleteShare(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    /**
     * 删除所有数据
     * @param context
     */
    public static void deleteAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }


}
