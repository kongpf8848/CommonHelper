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


    //判断是否有SD卡
    public static boolean hasSDCard()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
