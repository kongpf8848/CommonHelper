package com.kongpf.commonhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmHelper {

    private final static Map<Integer, String> mapList = new HashMap<Integer, String>();
    private final static char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

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


    private static String convertToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_CHARS[v >>> 4];
            hexChars[j * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String getHash(String text, int algorithm) {
        String hash = null;
        try {
            if (mapList.containsKey(algorithm)) {
                final MessageDigest digest = MessageDigest.getInstance(mapList.get(algorithm));
                final byte[] bytes = text.getBytes("UTF-8");
                digest.update(bytes, 0, bytes.length);
                hash = convertToHex(digest.digest());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String getMD5(String text) {
        return getHash(text, MD5);
    }

    public static String getMD5(File file) {
        String hash = null;
        if (file == null || !file.exists()) {
            return hash;
        }

        InputStream is = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            is = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, len);
            }
            byte[] bytes = messageDigest.digest();
            hash = convertToHex(bytes);
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
