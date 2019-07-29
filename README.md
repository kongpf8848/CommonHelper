# CommonHelper

Android开发常用的一些功能方法

![image]( https://github.com/kongpf8848/CommonHelper/blob/master/pic/demo.jpg)

# 添加依赖
```
implementation 'com.kongpf.commonhelper:common-helper:1.0.9'
```

# AlgorithmHelper
实现了MD5，SHA-1，SHA-256，SHA-384，SHA-512算法
```
getHash(String text, int algorithm);  //获取字符串的Hash值  

getMD5(String text);  //获取字符串的MD5值

getMD5(File file);  //获取文件的MD5值

```
# AlipayHelper
实现了支付宝相关的一些方法
```
isAlipayInstalled(Context context);  //判断支付宝是否安装

getAlipayVersionName(Context context);  //获取支付宝版本名称

getAlipayVersionCode(Context context);  //获取支付宝版本号

startAlipayClient(Activity activity, String urlCode);  //打开支付宝相关页面

openAlipayScan(Context context);  //打开支付宝扫一扫

openAlipayBarcode(Context context); //打开支付宝付款码

```
# ApkHelper
实现了Apk相关的一些方法
```
isDebugMode(Context context);  //判断程序是否为Debug模式

getApplicationMetaValue(Context context,String name);  //获取AndroidManifest.xml中的meta标签数据

getAppVersionName(Context context,String packageName);  //获取指定包名的版本名称

getAppVersionCode(Context context,String packageName);  //获取指定包名的版本号

installApk(Context context, File file, String authority);   //安装Apk，兼容Android7.0及以上版本

isMainProcess(Context context);   //判断当前进程是否为主进程

isInstalled(Context context,String packageName);  //判断指定应用是否安装

```
# AssetHelper
```
//复制assets目录下的文件到指定目录,如复制到SD卡上，需申请WRITE_EXTERNAL_STORAGE权限
copyAsset(Context context, String fileName, String destDir); 

```
# ByteHelper
```
byteArray2HexString(byte[] bArr); //字节数组转化为16进制字符串

hexString2ByteArray(String hexStr);   //16进制字符串转化为字节数组
```
# CameraHelper
```
isSupportCameraHardware(Context context)；//判断是否支持Camera
 
getCameraNumber();    //获取Camera数量
 
hasFrontCamera();   //是否有前置Camera

hasBackCamera();  //是否有后置Camera
 ```
# ScreenHelper
```
getScreenWidth(Context context);  //获取屏幕宽度

getScreenHeight(Context context);  //获取屏幕高度

getScreenDensity(Context context);  //获取屏幕密度

getScreenSize(Context context);   //获取屏幕宽度和高度

dp2px(Context context,float dp); //dp转换为px

sp2px(Context context,float sp); //sp转换为px
```
# StreamHelper
```
toString(InputStream is); //将InputStream转换为String

toByte(InputStream is); //将InputStream转换为字节数组
```
# SystemHelper
```
hasSDCard();  //判断是否有SD卡 
```
# ToastHelper
Toast帮助类
```
toast(int resId,int duration); //显示Toast

toast(String msg,int duration); //显示Toast
```
# ZipHelper
```
unzip(File zip, File dest); //解压zip文件到指定文件
```
# MarketHelper
```
isMarketAvailable(Context context);  //检查应用市场是否存在

gotoMarket(Context context, String appPackageName, String marketPackageName); //跳转到应用市场
```
# IntentHelper
```
launchApp(Context context, String packageName);  //跳转到指定应用

gotoAppSettings(Context context);  //跳转到应用详情
```
# ImageHelper
```
getAbsoluteImagePath(Context context, Uri uri); //获取url对应的路径
```
# StatusbarHelper
```
getStatusbarHeight(Context context);   //获取状态栏高度

setStatusBarTranslucent(Activity activity); //透明状态栏

setStatusBarColor(Activity activity, int color);  //设置状态栏颜色
```
# NotificationHelper
```
isNotficationEnabled(Context context); //判断通知功能是否开启

isChannelsEnabled(Context context, String channelId); //判断渠道通知是否开启

gotoChannelSetting(Context context, String channelId); //跳转到渠道设置

gotoNotificationSetting(Context context); //跳转到通知设置界面
```
# License
```
Copyright (C) 2019 kongpf8848

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


