package com.kongpf.commonhelper;

import android.content.Context;
import android.os.Environment;

import java.io.File;



public class StorageHelper {

    /**
     * 获取内部沙盒文件目录
     * /data/data/xxx/files
     *
     * @param context
     * @return
     */
    public static String getInternalFilesPath(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    /**
     * 获取内部沙盒缓存目录
     * /data/data/xxx/cache
     *
     * @param context
     * @return
     */
    public static String getInternalCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }

    /**
     * 获取外部沙盒文件根目录
     * /storage/emulated/0/Android/data/xxx/files
     *
     * @param context
     * @return
     */
    public static String getExternalSandBoxFilesPath(Context context) {
        return getExternalSandBoxPath(context, null);
    }

    public static String getExternalSandBoxPath(Context context, String type) {
        return context.getExternalFilesDir(type).getAbsolutePath();
    }

    /**
     * 获取外部沙盒缓存目录
     * /storage/emulated/0/Android/data/xxx/cache
     *
     * @param context
     * @return
     */
    public static String getExternalSandBoxCachePath(Context context) {
        return context.getExternalCacheDir().getAbsolutePath();
    }

    /**
     * 外部公共目录
     *
     * @param type
     * @return
     */
    public static String getExternalStoragePublicPath(String type) {
        return Environment.getExternalStoragePublicDirectory(type).getAbsolutePath();
    }

    /**
     * 外部公共目录文件
     *
     * @param type
     * @return
     */
    public static File getExternalStoragePublicDirectory(String type) {
        return Environment.getExternalStoragePublicDirectory(type);
    }

    /**
     * 是否有外部存储(SD卡)
     * @return
     */
    public static boolean hasExternalStorage()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
