package io.github.kongpf8848.commonhelper.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.github.kongpf8848.commonhelper.AlgorithmHelper;
import io.github.kongpf8848.commonhelper.AlipayHelper;
import io.github.kongpf8848.commonhelper.ApkHelper;
import io.github.kongpf8848.commonhelper.IntentHelper;
import io.github.kongpf8848.commonhelper.MarketHelper;
import io.github.kongpf8848.commonhelper.ScreenHelper;
import io.github.kongpf8848.commonhelper.ShortCutHelper;
import io.github.kongpf8848.commonhelper.ToastHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
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
        int width=ScreenHelper.getScreenWidth(this);
        int height=ScreenHelper.getScreenHeight(this);
        float density=ScreenHelper.getScreenDensity(this);
        int statusbarHeight=ScreenHelper.getStatusbarHeight(this);
        int navigationBarHeight=ScreenHelper.getNavigationBarHeight(this);
        int actionBarHeight=ScreenHelper.getActionBarHeight(this);
        Log.d("MainActivity", "width ="+width+",height="+height+",density="+density+",statusbarheight="+statusbarHeight+",navigationBarHeight="+navigationBarHeight+",actionBarHeight="+actionBarHeight);
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
        ToastHelper.toast("isPad:"+ScreenHelper.isPad(this));
    }

    @OnClick(R.id.button15)
    public void onButton15() {
        ShortCutHelper.createShortCut(this,"001","jack",R.mipmap.ic_launcher,this.getClass());
    }
}
