package com.kongpf.commonhelper;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.kongpf.commonhelper.bean.NotificationInfo;

public class NotificationHelper {

    //获取Builder
    private static NotificationCompat.Builder getNotificationBuilder(Context context, NotificationInfo notificationInfo) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannelGroup group = new NotificationChannelGroup(notificationInfo.getGroupId(), notificationInfo.getGroupName());
            notificationManager.createNotificationChannelGroup(group);
            NotificationChannel channel = new NotificationChannel(notificationInfo.getChannelId(), notificationInfo.getChannelName(), notificationInfo.getImportance());
            channel.setGroup(notificationInfo.getGroupId());
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(notificationInfo.getChannelId());
        }
        return builder;
    }

    //判断通知栏功能是否开启
    public static boolean isNotficationEnabled(Context context) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        return notificationManager.areNotificationsEnabled();
    }

    //判断渠道通知是否开启
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isChannelsEnabled(Context context, String channelId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
        if (notificationChannel != null && notificationChannel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
            return false;
        }
        return true;
    }

    //跳转到渠道设置
    public static void gotoChannelSetting( Context context, String channelId) {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        context.startActivity(intent);
    }


}
