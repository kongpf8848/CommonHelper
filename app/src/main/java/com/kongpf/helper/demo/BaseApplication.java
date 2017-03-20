package com.kongpf.helper.demo;

import android.app.Application;

import com.kongpf.commonhelper.ToastHelper;


/**
 * Created by pengf on 2017/3/16.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();

        ToastHelper.init(this);
    }
}
