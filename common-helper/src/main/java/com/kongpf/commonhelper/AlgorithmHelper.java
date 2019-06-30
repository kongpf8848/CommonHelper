package com.kongpf.commonhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmHelper {

    private final static Map<Integer, String> mapList = new HashMap<Integer, String>();

    public final static int SHA1 = 0;
    public final static int SHA256 = 1;
    public final static int SHA384 = 2;
    public final static int SHA512 = 3;
    public final static int MD5 = 4;

    static {
        mapList.put(SHA1, "SHA-1");
        mapList.put(SHA256, "SHA-256");
        mapList.put(SHA384, "SHA-384");
        mapList.put(SHA512, "SHA-512");
        mapList.put(MD5, "MD5");
    }

    /**
     * 获取字符串的Hash值
     * @param text
     * @param algorithm
     * @return
     */
    public static String getHash(String text, int algorithm) {
        String hash = null;
        try {
            if (mapList.containsKey(algorithm)) {
                final MessageDigest digest = MessageDigest.getInstance(mapList.get(algorithm));
                final byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
                digest.update(bytes, 0, bytes.length);
                hash = ByteHelper.byteArray2HexString(digest.digest());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * 获取字符串的MD5值
     * @param text
     * @return
     */
    public static String getMD5(String text) {
        return getHash(text, MD5);
    }

    /**
     * 获取文件的MD5值
     * @param file
     * @return
     */
    public static String getMD5(File file) {
        String hash = null;
        if (file==null || !file.exists()) {
            return hash;
        }
        InputStream is = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(mapList.get(MD5));
            is = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, len);
            }
            byte[] bytes = messageDigest.digest();
            hash = ByteHelper.byteArray2HexString(bytes);
        } catch (Exception e) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hash;
    }
}
