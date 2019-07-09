package com.kongpf.commonhelper;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class ImageHelper {

    //获取url对应的路径
    public static String getAbsoluteImagePath(Context context, Uri uri)
    {
        String imagePath = "";
        Cursor cursor = null;
        try{
            String[] projection = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(uri, projection, null, null, null);
            if (cursor != null)
            {
                int column_index = cursor.getColumnIndexOrThrow(projection[0]);
                if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                    imagePath = cursor.getString(column_index);
                }
            }
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return imagePath;
    }
}
