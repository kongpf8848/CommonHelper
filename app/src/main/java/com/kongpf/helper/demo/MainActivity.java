package com.kongpf.helper.demo;

import android.os.Bundle;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;

import com.kongpf.commonhelper.AlgorithmHelper;
import com.kongpf.commonhelper.AlipayHelper;
import com.kongpf.commonhelper.ApkHelper;
import com.kongpf.commonhelper.AssetHelper;
import com.kongpf.commonhelper.ByteHelper;
import com.kongpf.commonhelper.CameraHelper;
import com.kongpf.commonhelper.FileHelper;
import com.kongpf.commonhelper.IntentHelper;
import com.kongpf.commonhelper.MarketHelper;
import com.kongpf.commonhelper.ScreenHelper;
import com.kongpf.commonhelper.StreamHelper;
import com.kongpf.commonhelper.ToastHelper;

import java.io.File;
import java.io.InputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onButton1() {
        ToastHelper.toast("welcome to android");
    }

    @OnClick(R.id.button2)
    public void onButton2() {
        ToastHelper.toast(AlgorithmHelper.getMD5("123"));
    }

    @OnClick(R.id.button3)
    public void onButton3() {

        String packageName = "com.tencent.mm";
        if (ApkHelper.isInstalled(this, packageName)) {
            ToastHelper.toast("微信版本:" + ApkHelper.getAppVersionName(this, packageName));
        } else {
            ToastHelper.toast("机器没有安装微信!!!");
        }
    }

    @OnClick(R.id.button4)
    public void onButton4() {
        ToastHelper.toast(ScreenHelper.getScreenSize(this).toString());
    }

    @OnClick(R.id.button5)
    public void onButton5() {
        AlipayHelper.openAlipayScan(this);
    }

    @OnClick(R.id.button6)
    public void onButton6() {
        AlipayHelper.openAlipayBarcode(this);
    }

    @OnClick(R.id.button7)
    public void onButton7() {
        AlipayHelper.startAlipayClient(this, "aehvyvf4taua18zo6e");
    }

    @OnClick(R.id.button8)
    public void onButton8() {
        ToastHelper.toast("程序是否为Debug:" + ApkHelper.isDebugMode(this));
    }

    @OnClick(R.id.button9)
    public void onButton9() {
        ToastHelper.toast("meta:" + ApkHelper.getApplicationMetaValue(this, "CHANNEL"));
    }


    @OnClick(R.id.button10)
    public void onButton10() {
        IntentHelper.launchApp(this, Constants.PACKAGE_WECHAT);
    }

    @OnClick(R.id.button11)
    public void onButton11() {
        IntentHelper.gotoAppSettings(this);
    }

    @OnClick(R.id.button12)
    public void onButton12() {
        if (MarketHelper.isMarketAvailable(this)) {
            MarketHelper.gotoMarket(this, Constants.PACKAGE_WECHAT);
        } else {
            ToastHelper.toast("请先安装应用市场!!!");
        }
    }

    @OnClick(R.id.button13)
    public void onButton13() {
        if (MarketHelper.isMarketAvailable(this)) {
            MarketHelper.gotoGooglePlay(this,Constants.PACKAGE_WECHAT );
        } else {
            ToastHelper.toast("请先安装应用市场!!!");
        }
    }

    @OnClick(R.id.button14)
    public void onButton14() {
        File dir=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"taojiji");
        if (FileHelper.deleteDir(dir)) {
            ToastHelper.toast("delete ok");
        } else {
            ToastHelper.toast("delete fail");
        }
    }
}
