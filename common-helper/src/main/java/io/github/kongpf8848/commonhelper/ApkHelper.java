package io.github.kongpf8848.commonhelper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import androidx.core.content.FileProvider;

import java.io.File;
import java.util.List;

/**
 * Created by pengf on 2017/1/6.
 */

public class ApkHelper
{
    //判断程序是否为Debug模式
    public static boolean isDebugMode(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo pkginfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            if (pkginfo != null) {
                ApplicationInfo info = pkginfo.applicationInfo;
                return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            }

        } catch (Exception e) {

        }
        return false;
    }

    //获取AndroidManifest.xml中的meta标签数据
    public static String getApplicationMetaValue(Context context,String name) {
        String value = "";
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            value = String.valueOf(appInfo.metaData.get(name));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }


    public static String getAppVersionName(Context context)
    {
        return getAppVersionName(context,context.getPackageName());
    }

    public static int getAppVersionCode(Context context)
    {
        return getAppVersionCode(context,context.getPackageName());
    }

    public static String getAppVersionName(Context context,String packageName)
    {
        String version = "";
        try
        {
            version = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e)
        {
        }
        return version;
    }

    //获取指定包名的版本号
    public static int getAppVersionCode(Context context,String packageName)
    {
        int versionCode = 0;
        try
        {
            versionCode = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return versionCode;
    }

    /**
     *安装Apk
     * @param context
     * @param file
     * @param authority
     */
    public static void installApk(Context context, File file, String authority) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            PackageManager pm= context.getPackageManager();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (!pm.canRequestPackageInstalls()) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:"+ context.getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    return;
                }
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                uri = FileProvider.getUriForFile(context, authority, file);
            } else
            {
                uri = Uri.fromFile(file);
            }
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断当前进程是否为主进程
    public static boolean isMainProcess(Context context) {
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    //判断指定应用是否安装
    public static boolean isInstalled(Context context,String packageName)
    {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(packageName,0);
            return info != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    //获取APK签名
    public static String getSign(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Signature[] signatureList = packageInfo.signatures;
            if ((signatureList == null) || (signatureList.length == 0)) {
                return null;
            }
            return AlgorithmHelper.getMD5(new String(signatureList[0].toByteArray()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //判断当前应用是否从Google Play下载
    public static boolean isInstalledFromGooglePlay(Context context){
        try {
            String installer=context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installer!=null && installer.equals(MarketHelper.GOOGLEPLAY_PACKAGENAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
