package com.kongpf.commonhelper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.net.URISyntaxException;

/**
 * Created by pengf on 2017/4/14.
 */

public class AlipayHelper {

    private static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    private static final String INTENT_URL_FORMAT = "intent://platformapi/startapp?saId=10000007&" +
    "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F{urlCode}%3F_s" +
    "%3Dweb-other&_t=1472443966571#Intent;" +
    "scheme=alipayqr;package=com.eg.android.AlipayGphone;end";


    //判断支付宝是否安装
    public static boolean isAlipayInstalled(Context context)
    {
        return ApkHelper.isInstalled(context,ALIPAY_PACKAGE_NAME);
    }

    //获取支付宝版本名称
    public static String getAlipayVersionName(Context context)
    {
        return ApkHelper.getAppVersionName(context,ALIPAY_PACKAGE_NAME);
    }

    //获取支付宝版本号
    public static int getAlipayVersionCode(Context context)
    {
        return ApkHelper.getAppVersionCode(context,ALIPAY_PACKAGE_NAME);
    }

    //打开支付宝相关页面
    public static boolean startAlipayClient(Activity activity, String urlCode)
    {
        return startIntentUrl(activity, INTENT_URL_FORMAT.replace("{urlCode}", urlCode));
    }

    private static boolean startIntentUrl(Activity activity, String intentFullUrl) {
        try
        {
            Intent intent = Intent.parseUri(intentFullUrl, Intent.URI_INTENT_SCHEME);
            activity.startActivity(intent);
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    //打开支付宝扫一扫
    public static boolean openAlipayScan(Context context) {
        try {
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //打开支付宝付款码
    public static boolean openAlipayBarcode(Context context) {
        try {
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=20000056");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
