package com.kongpf.commonhelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class IntentHelper {

    //跳转到指定应用
    public static void launchApp(Context context, String packageName) {
        try {
           context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //跳转到应用详情
    public static void gotoAppSettings(Context context){
        Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:"+context.getPackageName()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
