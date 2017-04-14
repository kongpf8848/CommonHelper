package com.kongpf.helper.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kongpf.commonhelper.AlgorithmHelper;
import com.kongpf.commonhelper.AlipayHelper;
import com.kongpf.commonhelper.ApkHelper;
import com.kongpf.commonhelper.ScreenHelper;
import com.kongpf.commonhelper.ToastHelper;

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
    public void onButton1()
    {
        ToastHelper.toast("welcome to android");
    }

    @OnClick(R.id.button2)
    public void onButton2()
    {
        ToastHelper.toast(AlgorithmHelper.getMD5("123"));
    }

    @OnClick(R.id.button3)
    public void onButton3()
    {
        ToastHelper.toast(ApkHelper.getAppVersionName(this));
    }

    @OnClick(R.id.button4)
    public void onButton4()
    {
        ToastHelper.toast(ScreenHelper.getScreenSize(this).toString());
    }

    @OnClick(R.id.button5)
    public void onButton5()
    {
        AlipayHelper.openAlipayScan(this);
    }

    @OnClick(R.id.button6)
    public void onButton6()
    {
        AlipayHelper.openAlipayBarcode(this);
    }
    @OnClick(R.id.button7)
    public void onButton7()
    {
        AlipayHelper.startAlipayClient(this,"aehvyvf4taua18zo6e");
    }
}
