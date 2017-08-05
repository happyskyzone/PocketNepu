package com.nepu.preeminence.pocketnepu.utils;

import android.util.Log;

/**
 * log封装类
 */

public class L {
    //所有log的开关
    public static final boolean DEBUG = true;
    //TAG
    private static final String TAG = "PocketNepu";

    /**
     * info
     * @param text
     */
    public static void i(String text){
        if (DEBUG){
            Log.i(TAG, text);
        }
    }

    /**
     * debug
     * @param text
     */
    public static void d(String text){
        if (DEBUG){
            Log.d(TAG, text);
        }
    }

    /**
     * warning
     * @param text
     */
    public static void w(String text){
        if (DEBUG){
            Log.w(TAG, text);
        }
    }

    /**
     * error
     * @param text
     */
    public static void e(String text){
        if (DEBUG){
            Log.e(TAG, text);
        }
    }


}
