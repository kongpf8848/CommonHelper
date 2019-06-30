package com.kongpf.commonhelper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipHelper {

    //解压zip文件到指定文件
    public static void unzip(File zip, File dest) throws IOException {

        ZipFile zipFile = new ZipFile(zip);

        try {
            Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();

                if (entry.isDirectory()) {
                    (new File(dest, entry.getName())).mkdirs();
                    continue;
                }

                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(dest, entry.getName())));
                try {
                    copyInputStream(zipFile.getInputStream(entry), outputStream);
                } finally {
                    outputStream.close();
                }
            }
        } finally {
            zipFile.close();
        }
    }

    private static void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;

        while ((len = in.read(buffer)) >= 0) {
            out.write(buffer, 0, len);
        }
        out.flush();

        in.close();
        out.close();
    }

}
