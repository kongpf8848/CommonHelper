package com.kongpf.commonhelper;

/**
 * Created by pengf on 2018/2/28.
 */

public class ByteHelper {

    private static final String HEXSTRING = "0123456789ABCDEF";

    public static byte hexChar2Byte(char c) {
        return (byte) (HEXSTRING.indexOf(String.valueOf(c).toUpperCase()));
    }

    public static String byteArray2HexString(byte[] bArr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = bArr.length; i < len; i++) {
            builder.append(String.format("%02X", bArr[i]));
        }
        return builder.toString();
    }

    public static byte[] hexString2ByteArray(String hexStr) {
        if (hexStr == null) {
            return null;
        } else if (hexStr.length() % 2 != 0) {
            return null;
        } else {
            int len = (hexStr.length() / 2);
            byte[] data = new byte[len];
            char[] chArray = hexStr.toCharArray();
            for (int i = 0; i < len; i++) {
                data[i] = (byte) ((hexChar2Byte(chArray[2 * i]) << 4) + hexChar2Byte(chArray[2 * i + 1]));
            }
            return data;
        }
    }


}
