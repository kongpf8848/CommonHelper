package io.github.kongpf8848.commonhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;

public class IntentHelper {

    public static boolean launchApp(Context context, String packageName) {
        try {
           context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
           return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean launchAppWithScheme(Context context,String scheme){
        try {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(scheme));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void gotoAppSettings(Context context){
        Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:"+context.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoApplicationSettings(Context context) {
        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoWifiSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoDevelopmentSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoLocationSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void gotoSelectPhoto(Activity activity, int requestCode) {
        Intent intent=new Intent();
        intent.setType("image/*");
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.KITKAT) {
            intent.setAction(Intent.ACTION_PICK);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        } else {
            intent.setAction(Intent.ACTION_GET_CONTENT);
        }
        activity.startActivityForResult(Intent.createChooser(intent, "选择图片"), requestCode);
    }

}
