package com.github.kongpf8848.commonhelper;

import android.app.LauncherActivity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.pm.ShortcutInfoCompat;
import android.support.v4.content.pm.ShortcutManagerCompat;
import android.support.v4.graphics.drawable.IconCompat;

public class ShortCutHelper {

    public static final String ACTION_ADD_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";


    //创建桌面快捷方式
    public static void createShortCut(Context context, String id, String label, int resId, Class<?> cls) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
                Intent launchIntent = new Intent(context, cls);
                launchIntent.setAction(Intent.ACTION_VIEW);
                ShortcutInfoCompat shortCutInfo = new ShortcutInfoCompat.Builder(context, id)
                        .setShortLabel(label)
                        .setIcon(IconCompat.createWithResource(context,resId))
                        .setIntent(launchIntent)
                        .build();
                PendingIntent shortcutCallbackIntent = PendingIntent.getBroadcast(context, 0, new Intent(context, ShortCutBroadcastReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);
                ShortcutManagerCompat.requestPinShortcut(context, shortCutInfo, shortcutCallbackIntent.getIntentSender());
            }
        }
        else{
            try {
                Intent addShortcutIntent = new Intent(ACTION_ADD_SHORTCUT);
                addShortcutIntent.putExtra("duplicate", false);
                addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, label);
                addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, resId));

                Intent launcherIntent = new Intent();
                launcherIntent.setClass(context, cls);
                addShortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, launcherIntent);
                context.sendBroadcast(addShortcutIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static class ShortCutBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
