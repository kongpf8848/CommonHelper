package io.github.kongpf8848.commonhelper.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.github.kongpf8848.commonhelper.AlgorithmHelper;
import io.github.kongpf8848.commonhelper.AlipayHelper;
import io.github.kongpf8848.commonhelper.ApkHelper;
import io.github.kongpf8848.commonhelper.IntentHelper;
import io.github.kongpf8848.commonhelper.MarketHelper;
import io.github.kongpf8848.commonhelper.ScreenHelper;
import io.github.kongpf8848.commonhelper.ShortCutHelper;
import io.github.kongpf8848.commonhelper.ToastHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] buttonIds = {
                R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9,
                R.id.button10, R.id.button11, R.id.button12,
                R.id.button13, R.id.button14, R.id.button15
        };
        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(v -> {
                switch (id) {
                    case R.id.button1:
                        onButton1();
                        break;
                    case R.id.button2:
                        onButton2();
                        break;
                    case R.id.button3:
                        onButton3();
                        break;
                    case R.id.button4:
                        onButton4();
                        break;
                    case R.id.button5:
                        onButton5();
                        break;
                    case R.id.button6:
                        onButton6();
                        break;
                    case R.id.button7:
                        onButton7();
                        break;
                    case R.id.button8:
                        onButton8();
                        break;
                    case R.id.button9:
                        onButton9();
                        break;
                    case R.id.button10:
                        onButton10();
                        break;
                    case R.id.button11:
                        onButton11();
                        break;
                    case R.id.button12:
                        onButton12();
                        break;
                    case R.id.button13:
                        onButton13();
                        break;
                    case R.id.button14:
                        onButton14();
                        break;
                    case R.id.button15:
                        onButton15();
                        break;
                }
            });
        }


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onButton1() {
        ToastHelper.toast("welcome to android");
    }

    public void onButton2() {
        ToastHelper.toast(AlgorithmHelper.getMD5("123"));
    }

    public void onButton3() {

        String packageName = "com.tencent.mm";
        if (ApkHelper.isInstalled(this, packageName)) {
            ToastHelper.toast("微信版本:" + ApkHelper.getAppVersionName(this, packageName));
        } else {
            ToastHelper.toast("机器没有安装微信!!!");
        }
    }

    public void onButton4() {
        int width = ScreenHelper.getScreenWidth(this);
        int height = ScreenHelper.getScreenHeight(this);
        float density = ScreenHelper.getScreenDensity(this);
        int statusbarHeight = ScreenHelper.getStatusbarHeight(this);
        int navigationBarHeight = ScreenHelper.getNavigationBarHeight(this);
        int actionBarHeight = ScreenHelper.getActionBarHeight(this);
        Log.d("MainActivity", "width =" + width + ",height=" + height + ",density=" + density + ",statusbarheight=" + statusbarHeight + ",navigationBarHeight=" + navigationBarHeight + ",actionBarHeight=" + actionBarHeight);
    }

    public void onButton5() {
        AlipayHelper.openAlipayScan(this);
    }

    public void onButton6() {
        AlipayHelper.openAlipayBarcode(this);
    }

    public void onButton7() {
        AlipayHelper.startAlipayClient(this, "aehvyvf4taua18zo6e");
    }

    public void onButton8() {
        ToastHelper.toast("程序是否为Debug:" + ApkHelper.isDebugMode(this));
    }

    public void onButton9() {
        ToastHelper.toast("meta:" + ApkHelper.getApplicationMetaValue(this, "CHANNEL"));
    }


    public void onButton10() {
        IntentHelper.launchApp(this, Constants.PACKAGE_WECHAT);
    }

    public void onButton11() {
        IntentHelper.gotoAppSettings(this);
    }

    public void onButton12() {
        if (MarketHelper.isMarketAvailable(this)) {
            MarketHelper.gotoMarket(this, Constants.PACKAGE_WECHAT);
        } else {
            ToastHelper.toast("请先安装应用市场!!!");
        }
    }

    public void onButton13() {
        if (MarketHelper.isMarketAvailable(this)) {
            MarketHelper.gotoGooglePlay(this, Constants.PACKAGE_WECHAT);
        } else {
            ToastHelper.toast("请先安装应用市场!!!");
        }
    }

    public void onButton14() {
        ToastHelper.toast("isPad:" + ScreenHelper.isPad(this));
    }

    public void onButton15() {
        ShortCutHelper.createShortCut(this, "001", "jack", R.mipmap.ic_launcher, this.getClass());
    }
}
