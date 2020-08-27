package com.kongpf.commonhelper;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ScreenHelper 
{

	//获取屏幕宽度
	public static int getScreenWidth(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.widthPixels;
	}

	//获取屏幕高度
	public static int getScreenHeight(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.heightPixels;
	}

	//获取屏幕密度
	public static float getScreenDensity(Context context) {
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.density;
	}

	//获取屏幕宽度和高度
	public static ScreenSize getScreenSize(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return new ScreenSize(displayMetrics.widthPixels,displayMetrics.heightPixels);
	}

	//dp转换为px
	public static int dp2px( Context context,float dp)
	{
		return xp2px(context,dp,TypedValue.COMPLEX_UNIT_DIP);
	}
	//sp转换为px
	public static int sp2px(Context context,float sp)
	{
		return xp2px(context,sp,TypedValue.COMPLEX_UNIT_SP);
	}

	private static int xp2px( Context context,float f,int unit)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return (int)TypedValue.applyDimension(unit,f,displayMetrics);

	}

	//是否为平板
	public static boolean isPad(Context context) {
		Configuration configuration=context.getResources().getConfiguration();
		int x=configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
		return x>= Configuration.SCREENLAYOUT_SIZE_LARGE;
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
