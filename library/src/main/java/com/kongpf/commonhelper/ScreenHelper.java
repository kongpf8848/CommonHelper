package com.kongpf.commonhelper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class ScreenHelper 
{

	public static int getScreenWidth(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.widthPixels;
	}


	public static int getScreenHeight(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.heightPixels;
	}

	public static float getScreenDensity(Context context) {
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return  displayMetrics.density;
	}


	public static ScreenSize getScreenSize(Context context)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return new ScreenSize(displayMetrics.widthPixels,displayMetrics.heightPixels);
	}

	public static int dp2px( Context context,float dp)
	{
		return xp2px(context,dp,TypedValue.COMPLEX_UNIT_DIP);
	}

	public static int sp2px(Context context,float sp)
	{
		return xp2px(context,sp,TypedValue.COMPLEX_UNIT_SP);
	}

	private static int xp2px( Context context,float f,int unit)
	{
		DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
		return (int)TypedValue.applyDimension(unit,f,displayMetrics);

	}


	public static class ScreenSize {

		private final int mWidth;
		private final int mHeight;

		public ScreenSize(int width, int height) {
			mWidth = width;
			mHeight = height;
		}

		public int getWidth() {
			return mWidth;
		}

		public int getHeight() {
			return mHeight;
		}


		@Override
		public String toString() {
			return mWidth + "x" + mHeight;
		}

	}

}
