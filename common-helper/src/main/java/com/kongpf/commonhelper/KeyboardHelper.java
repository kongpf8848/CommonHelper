package com.kongpf.commonhelper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardHelper {

    /**
     * 显示键盘
     * @param view
     */
    public static void showSoftInput(final View view) {
        if(view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    /**
     * 隐藏键盘
     * @param activity
     */
    public static void hideSoftInput(final Activity activity) {
        if(activity != null) {
           hideSoftInput(activity.getCurrentFocus());
        }
    }
    public static void hideSoftInput(final View view) {
        if(view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
