# CommonHelper

Android开发常用的一些功能方法

![image]( https://github.com/kongpf8848/CommonHelper/blob/master/pic/demo.jpg)

# 添加依赖
```
compile 'com.kongpf.commonhelper:common-helper:1.0.7'
```

# AlgorithmHelper
实现了MD5，SHA-1，SHA-256，SHA-384，SHA-512算法
```
AlgorithmHelper.getHash(String text, int algorithm);  //获取字符串的Hash值  

AlgorithmHelper.getMD5(String text);  //获取字符串的MD5值

AlgorithmHelper.getMD5(File file);  //获取文件的MD5值

```
# AlipayHelper
实现了支付宝相关的一些方法
```
AlipayHelper.isAlipayInstalled(Context context);  //判断支付宝是否安装

AlipayHelper.getAlipayVersionName(Context context);  //获取支付宝版本名称

AlipayHelper.getAlipayVersionCode(Context context);  //获取支付宝版本号

AlipayHelper.startAlipayClient(Activity activity, String urlCode);  //打开支付宝相关页面

AlipayHelper.openAlipayScan(Context context);  //打开支付宝扫一扫

AlipayHelper.openAlipayBarcode(Context context); //打开支付宝付款码

```
# ApkHelper
实现了Apk相关的一些方法
```
ApkHelper.isDebugMode(Context context);  //判断程序是否为Debug模式

ApkHelper.getApplicationMetaValue(Context context,String name);  //获取AndroidManifest.xml中的meta标签数据

ApkHelper.getAppVersionName(Context context,String packageName);  //获取指定包名的版本名称

ApkHelper.getAppVersionCode(Context context,String packageName);  //获取指定包名的版本号

ApkHelper.installApk(Context context, File file, String authority);   //安装Apk，兼容Android7.0及以上版本

ApkHelper.isMainProcess(Context context);   //判断当前进程是否为主进程

ApkHelper.isInstalled(Context context,String packageName);  //判断指定应用是否安装

```
# AssetHelper
```
//复制assets目录下的文件到指定目录,如复制到SD卡上，需申请WRITE_EXTERNAL_STORAGE权限
AssetHelper.copyAsset(Context context, String fileName, String destDir); 

```
# ByteHelper
```
ByteHelper.byteArray2HexString(byte[] bArr); //字节数组转化为16进制字符串

ByteHelper.hexString2ByteArray(String hexStr);   //16进制字符串转化为字节数组
```
# CameraHelper
```
 CameraHelper.isSupportCameraHardware(Context context)；//判断是否支持Camera
 
 CameraHelper.getCameraNumber();    //获取Camera数量
 
 CameraHelper.hasFrontCamera();   //是否有前置Camera
 
 CameraHelper.hasBackCamera();  //是否有后置Camera
 ```
# ScreenHelper
```
ScreenHelper.getScreenWidth(Context context);  //获取屏幕宽度

ScreenHelper.getScreenHeight(Context context);  //获取屏幕高度

ScreenHelper.getScreenDensity(Context context);  //获取屏幕密度

ScreenHelper.getScreenSize(Context context);   //获取屏幕宽度和高度

ScreenHelper.dp2px(Context context,float dp); //dp转换为px

ScreenHelper.sp2px(Context context,float sp); //sp转换为px
```
# StreamHelper
```
StreamHelper.toString(InputStream is); //将InputStream转换为String

StreamHelper.toByte(InputStream is); //将InputStream转换为字节数组
```
# SystemHelper
```
SystemHelper.getStatusbarHeight(Context context);   //获取状态栏高度

SystemHelper.hasSDCard();  //判断是否有SD卡 
```
# ToastHelper
Toast帮助类
```
ToastHelper.toast(int resId,int duration); //显示Toast

ToastHelper.toast(String msg,int duration); //显示Toast
```
# ZipHelper
```
ZipHelper.unzip(File zip, File dest); //解压zip文件到指定文件
```
MarketHelper
```
MarketHelper.isMarketAvailable(Context context);  //检查应用市场是否存在

MarketHelper.gotoMarket(Context context, String appPackageName, String marketPackageName); //跳转到应用市场
```
IntentHelper
```
IntentHelper.launchApp(Context context, String packageName);  //跳转到指定应用

IntentHelper.gotoAppSettings(Context context);  //跳转到应用详情
```



