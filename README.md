# CommonHelper

Android开发常用的一些功能方法合集,集成了很多简单方便的功能,大大提高开发效率。

![image]( https://github.com/kongpf8848/CommonHelper/blob/master/pic/demo.jpg)

# 添加依赖
* 在项目根目录的build.gradle文件中添加：
```
allprojects {
    repositories {
        mavenCentral()
    }
}
```
* 在具体Module的build.gradle文件中添加：
```
implementation 'io.github.kongpf8848:common-helper:1.0.21'
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

getSign(Context context, String packageName); //获取指定包名的签名

isInstalledFromGooglePlay(Context context); //判断当前应用是否从Google Play下载

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
isSupportCameraHardware(Context context); //判断机器是否支持Camera
 
getCameraNumber();    //获取Camera数量
 
hasFrontCamera();   //是否有前置Camera

hasBackCamera();  //是否有后置Camera
 ```
# DateHelper
```
formatDate(SimpleDateFormat dateFormat, Date date); //格式化日期
```
# FileHelper
```
deleteDir(File dir); //删除指定目录
```
# ImageHelper
```
getAbsoluteImagePath(Context context, Uri uri); //获取url对应的路径

revert(@NonNull ImageView imageView); //对ImageView像素进行倒置

rotate(ImageView imageView,float degree); //对ImageView进行旋转

getRotateDegree(String filePath); //获取图片旋转角度
```
# IntentHelper
```
launchApp(Context context, String packageName);  //跳转到指定应用

gotoAppSettings(Context context);  //跳转到应用详情

gotoWifiSettings(Context context); //跳转到WLAN设置

gotoSettings(Context context); //跳转到系统设置

gotoDevelopmentSettings(Context context); //跳转到开发者选项

gotoLocationSettings(Context context); //跳转到位置设置

gotoSelectPhoto(Activity activity, int requestCode); //从相册中选择照片
```
# MarketHelper
```
isMarketAvailable(Context context);  //检查应用市场是否存在

gotoMarket(Context context, String appPackageName, String marketPackageName); //跳转到应用市场

gotoGooglePlay(Context context, String appPackageName); //跳转到GooglePlay商店
```
# NotificationHelper
```
getNotificationBuilder(Context context, NotificationInfo notificationInfo); //获取 Notification Builder

isNotficationEnabled(Context context); //判断通知功能是否开启

isChannelsEnabled(Context context, String channelId); //判断渠道通知是否开启

gotoChannelSetting(Context context, String channelId); //跳转到渠道设置

gotoNotificationSetting(Context context); //跳转到通知设置界面
```
# ScreenHelper
```
getScreenWidth(Context context);  //获取屏幕宽度

getScreenHeight(Context context);  //获取屏幕高度

getScreenDensity(Context context);  //获取屏幕密度

getScreenSize(Context context);   //获取屏幕宽度和高度

dp2px(Context context,float dp); //dp转换为px

sp2px(Context context,float sp); //sp转换为px

isPad(Context context); //是否为平板

getStatusbarHeight(Context context);  //获取状态栏高度

getNavigationBarHeight(Context context); //获取导航栏高度

getActionBarHeight(Context context); //获取ActionBar高度

```
# ShortCutHelper
```
createShortCut(Context context, String id, String label, int resId, Class<?> cls); //创建桌面快捷方式
```
# StreamHelper
```
toString(InputStream is); //将InputStream转换为String

toByte(InputStream is); //将InputStream转换为字节数组
```
# StorageHelper
```
getInternalFilesPath(Context context);  //获取内部沙盒文件目录(/data/data/xxx/files)

getInternalCachePath(Context context); //获取内部沙盒缓存目录(/data/data/xxx/cache)

getExternalSandBoxFilesPath(Context context); //获取外部沙盒文件根目录(/storage/emulated/0/Android/data/xxx/files)

getExternalSandBoxPath(Context context, String type); //根据类型获取外部沙盒文件目录

getExternalSandBoxCachePath(Context context); //获取外部沙盒缓存目录(/storage/emulated/0/Android/data/xxx/cache)

getExternalStoragePublicPath(String type); //根据类型获取外部公共目录

hasExternalStorage(); //是否有外置存储
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
# StatusbarHelper
```
setStatusBarTranslucent(Activity activity); //透明状态栏

setStatusBarColor(Activity activity, int color);  //设置状态栏颜色
```
# KeyboardHelper
```
showSoftInput(final View view); //显示键盘

hideSoftInput(final View view); //隐藏键盘
```

# License
```
Copyright (C) 2021 kongpf8848

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


