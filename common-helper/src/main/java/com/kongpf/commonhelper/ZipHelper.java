package com.kongpf.commonhelper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipHelper {

    /**
     * 解压zip文件到指定目录
     * unzip(new File("1.zip"),new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"test"))
     */
    public static void unzip(File source, File dest) throws IOException {
        ZipFile zipFile = new ZipFile(source);
        try {
            if(!dest.exists()){
                dest.mkdirs();
            }
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(source)));
            ZipEntry entry;
            byte[] buffer = new byte[1024];
            while((entry=zis.getNextEntry())!=null) {
                String filename = entry.getName();
                //排除MACOS环境下生成的临时文件
                if (filename.contains("__MACOSX")) {
                }
                else {
                    if (entry.isDirectory()) {
                        new File(dest,filename).mkdirs();
                        continue;
                    }
                    InputStream inputStream=zipFile.getInputStream(entry);
                    int len;
                    try (FileOutputStream outputStream =new FileOutputStream(new File(dest, filename))) {
                        while ((len = inputStream.read(buffer)) >= 0) {
                            outputStream.write(buffer, 0, len);
                        }
                        outputStream.flush();
                        inputStream.close();
                    }
                }
                zis.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zipFile.close();
        }
    }

}
