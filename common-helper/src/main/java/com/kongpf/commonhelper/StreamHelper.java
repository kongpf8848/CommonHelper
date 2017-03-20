package com.kongpf.commonhelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pengf on 2017/2/21.
 */

public class StreamHelper {

    public static String readStream(InputStream is)
    {
        try {
            byte[] byteStream = toByte(is);
            return new String(byteStream,"utf-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public static byte[] toByte(InputStream is) throws IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[]buffer=new byte[1024];
        int len=-1;
        while ((len=is.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }
        baos.flush();
        baos.close();
        is.close();

        return baos.toByteArray();
    }
}
