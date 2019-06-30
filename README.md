# CommonHelper

Android开发常用的一些功能方法

# 添加依赖
```
compile 'com.kongpf.commonhelper:common-helper:1.0.6'
```

# AlgorithmHelper
实现了MD5，SHA-1，SHA-256，SHA-384，SHA-512算法
```
AlgorithmHelper.getMD5("123")  //获取字符串的MD5值

AlgorithmHelper.getMD5(new File("xxx")) //获取文件的MD5值
```
