package com.kongpf.commonhelper;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

/**
 * Created by pengf on 2016/10/27.
 *
 */

public class CameraHelper
{

    //判断是否支持Camera
    public static boolean isSupportCameraHardware(Context context)
    {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    //获取Camera数量
    public static int getCameraNumbers()
    {
        return Camera.getNumberOfCameras();
    }

    //是否有前置Camera
    public static boolean hasFrontCamera()
    {
        return hasCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

    }
    //是否有后置Camera
    public static boolean hasBackCamera()
    {
        return hasCamera(Camera.CameraInfo.CAMERA_FACING_BACK);
    }
    private static boolean hasCamera(int cameraId)
    {
        int number=getCameraNumbers();

        if(number==0)return false;
        for(int i=0;i<number;i++)
        {
            Camera.CameraInfo cameraInfo=new Camera.CameraInfo();
            Camera.getCameraInfo(i,cameraInfo);
            if(cameraInfo.facing==cameraId)
            {
                return true;
            }
        }
        return false;
    }




}
