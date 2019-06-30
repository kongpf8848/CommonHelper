package com.kongpf.commonhelper;

import android.app.Application;
import android.view.Gravity;
import android.widget.Toast;

import static android.widget.Toast.makeText;


/**
 * Created by kongpengfei on 2016/5/17.
 */
public class ToastHelper
{
    private static Application app;

    public static void init(Application application)
    {
        app=application;
    }


    public static void toast(int resId)
    {
        if(app!=null)
        {
            makeText(app, resId, Toast.LENGTH_SHORT).show();
        }
    }
    public static void toast(String msg)
    {
        if(app!=null)
        {
            makeText(app, msg, Toast.LENGTH_SHORT).show();
        }
    }
    public static void toast(int resId,int duration)
    {
        if(app!=null) {
            makeText(app, resId, duration).show();
        }
    }
    public static void toast(String msg,int duration)
    {
        if(app!=null)
        {
            makeText(app, msg, duration).show();
        }
    }

    public static void toastCenter(String msg)
    {
        if(app!=null) {
            Toast toast= makeText(app, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
    public static void toastCenter(int resId)
    {
        if(app!=null) {
            Toast toast= makeText(app, resId, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}
