package io.github.kongpf8848.commonhelper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

import java.util.List;

public class MarketHelper {

    public static final String MARKET_DATA = "market://details";
    public static final String GOOGLEPLAY_PACKAGENAME = "com.android.vending";

    public static boolean isMarketAvailable(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(MARKET_DATA));
        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, 0);
        return list != null && list.size() > 0;

    }

    public static void gotoMarket(Context context, String appPackageName) {
        gotoMarket(context, appPackageName, null);
    }

    public static void gotoGooglePlay(Context context, String appPackageName) {
        gotoMarket(context, appPackageName, GOOGLEPLAY_PACKAGENAME);
    }

    public static void gotoMarket(Context context, String appPackageName, String marketPackageName) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(String.format("%s?id=%s", MARKET_DATA, appPackageName)));
            if (!TextUtils.isEmpty(marketPackageName)) {
                intent.setPackage(marketPackageName);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
