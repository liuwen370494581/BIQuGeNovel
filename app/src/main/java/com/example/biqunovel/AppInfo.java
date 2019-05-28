package com.example.biqunovel;

import android.app.Application;
import android.content.Context;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 10:55
 * desc   :
 */
public class AppInfo extends Application {
    private static Context sInstance;

    public static Context getContext() {
        return sInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化greenDao3
        sInstance = this;
    }

}
