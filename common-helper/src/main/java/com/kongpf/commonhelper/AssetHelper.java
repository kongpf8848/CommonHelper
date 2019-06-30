package com.kongpf.commonhelper;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pengf on 2017/1/5.
 */

public class AssetHelper {

    //复制assets目录下的文件到指定目录
    public static boolean copyAsset(Context context, String fileName, String destDir) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = context.getResources().getAssets().open(fileName);
            if (!destDir.endsWith(File.separator)) destDir += File.separator;
            File parent = new File(destDir);
            if (!parent.exists()) {
                parent.mkdirs();
            }
            out = new FileOutputStream(destDir + fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
