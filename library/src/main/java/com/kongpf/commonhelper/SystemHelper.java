package com.kongpf.commonhelper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by pengf on 2016/12/25.
 */

public class SystemHelper
{

    public static void setStatusbarColor(Activity activity, int color) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View statusBarView = new View(activity);
            statusBarView.setBackgroundColor(color);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusbarHeight(activity));
            viewGroup.addView(statusBarView, lp);
        }
    }



    public static int getStatusbarHeight(Context context) {
        int statusHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusHeight;
    }


    public static boolean isMIUI()  {
        Properties properties = new Properties();
        try
        {
            String str=Environment.getRootDirectory().getAbsolutePath();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            if ((properties.getProperty("ro.miui.ui.version.code", null) != null) || (properties.getProperty("ro.miui.ui.version.name", null) != null) || (properties.getProperty("ro.miui.internal.storage", null) != null)) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }


    public static void gotoSystemSetting(Context context)
    {
        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails"));
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public static String getIMEI(Context context)
    {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }


    public static boolean hasSDCard()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
