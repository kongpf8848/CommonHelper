package io.github.kongpf8848.commonhelper;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import io.github.kongpf8848.commonhelper.bean.NotificationInfo;

public class NotificationHelper {

    //获取 Notification Builder
    public static NotificationCompat.Builder getNotificationBuilder(Context context, NotificationInfo notificationInfo) {
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

    public static boolean isNotficationEnabled(Context context) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        return notificationManager.areNotificationsEnabled();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isChannelsEnabled(Context context, String channelId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
        if (notificationChannel != null && notificationChannel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
            return false;
        }
        return true;
    }

    public static void gotoChannelSetting( Context context, String channelId) {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        context.startActivity(intent);
    }

    public static void gotoNotificationSetting(Context context){
        try{
            Intent intent = new Intent();
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
            }
            else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra("app_package",context.getPackageName());
                intent.putExtra("app_uid",context.getApplicationInfo().uid);
            }
            else{
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:"+context.getPackageName()));
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
            IntentHelper.gotoAppSettings(context);
        }
    }


}
