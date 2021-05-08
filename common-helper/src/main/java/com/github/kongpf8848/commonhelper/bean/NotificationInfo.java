package com.github.kongpf8848.commonhelper.bean;

import android.app.NotificationManager;

public class NotificationInfo {

    private String groupId;
    private String groupName;
    private String channelId;
    private String channelName;
    private int importance;

    public NotificationInfo(String groupId, String groupName, String channelId, String channelName) {
        this(groupId,groupName,channelId,channelName, NotificationManager.IMPORTANCE_DEFAULT);
    }

    public NotificationInfo(String groupId, String groupName, String channelId, String channelName, int importance) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.channelId = channelId;
        this.channelName = channelName;
        this.importance = importance;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
