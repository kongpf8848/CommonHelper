# CommonHelper

Android开发常用的一些功能方法

# 添加依赖
```
compile 'com.kongpf.commonhelper:common-helper:1.0.6'
```

# AlgorithmHelper
实现了MD5，SHA-1，SHA-256，SHA-384，SHA-512算法
```
AlgorithmHelper.getMD5("123");  //获取字符串的MD5值  

AlgorithmHelper.getMD5(new File("xxx"));  //获取文件的MD5值

```
# AlipayHelper
实现了支付宝相关的一些方法
```
AlipayHelper.isAlipayInstalled(this);  //判断支付宝是否安装

AlipayHelper.getAlipayVersionName(this);  //获取支付宝版本名称

AlipayHelper.getAlipayVersionCode(this);  //获取支付宝版本号

AlipayHelper.startAlipayClient(this, "aehvyvf4taua18zo6e");  //打开支付宝相关页面

AlipayHelper.openAlipayScan(this);  //打开支付宝扫一扫

AlipayHelper.openAlipayBarcode(this); //打开支付宝付款码

```
# ApkHelper
实现了Apk相关的一些方法
```
ApkHelper.isDebugMode(this);  //判断程序是否为Debug模式

ApkHelper.getApplicationMetaValue(this,"xxx");  //获取AndroidManifest.xml中的meta标签数据

ApkHelper.getAppVersionName(this, "com.tencent.mm");  //获取指定包名的版本名称

ApkHelper.getAppVersionCode(this, "com.tencent.mm");  //获取指定包名的版本号

ApkHelper.installApk(this,new File("xxx"),"xxx");   //安装Apk，兼容Android7.0及以上版本

ApkHelper.isMainProcess(this);   //判断当前进程是否为主进程

ApkHelper.isInstalled(this,"com.tencent.mm");  //判断指定应用是否安装


```
