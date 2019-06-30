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

    public static boolean isSupportCameraHardware(Context context)
    {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }


    public static int getCameraNumber()
    {
        return Camera.getNumberOfCameras();
    }


    public static boolean hasCamera(int cameraId)
    {
        int number=getCameraNumber();

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


    public static boolean hasFrontCamera()
    {
        return hasCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

    }

    public static boolean hasBackCamera()
    {
        return hasCamera(Camera.CameraInfo.CAMERA_FACING_BACK);
    }



}
