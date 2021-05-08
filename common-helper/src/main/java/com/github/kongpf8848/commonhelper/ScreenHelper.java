package com.github.kongpf8848.commonhelper;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ScreenHelper {

    //获取屏幕宽度
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    //获取屏幕高度
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    //获取屏幕密度
    public static float getScreenDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.density;
    }

    //获取屏幕宽度和高度
    public static ScreenSize getScreenSize(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new ScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    //dp转换为px
    public static int dp2px(Context context, float dp) {
        return xp2px(context, dp, TypedValue.COMPLEX_UNIT_DIP);
    }

    //sp转换为px
    public static int sp2px(Context context, float sp) {
        return xp2px(context, sp, TypedValue.COMPLEX_UNIT_SP);
    }

    private static int xp2px(Context context, float f, int unit) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(unit, f, displayMetrics);

    }

    //是否为平板
    public static boolean isPad(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int x = configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        return x >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    //获取状态栏高度
    public static int getStatusbarHeight(Context context) {
        int statusHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusHeight;
    }


	//获取导航栏高度
	public static int getNavigationBarHeight(Context context){
		String field="";
		if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			field="navigation_bar_height";
		} else {
			field="navigation_bar_height_landscape";
		}
		int resourceId = context.getResources().getIdentifier(field, "dimen", "android");
		if (resourceId > 0) {
			return context.getResources().getDimensionPixelSize(resourceId);
		} else {
			return 0;
		}
	}

	//获取ActionBar高度
    public static int getActionBarHeight(Context context) {
        int height = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            height = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return height;
    }


    public static class ScreenSize {

        private int width;
        private int height;

        public ScreenSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


        @Override
        public String toString() {
            return width + "x" + height;
        }

    }

}
