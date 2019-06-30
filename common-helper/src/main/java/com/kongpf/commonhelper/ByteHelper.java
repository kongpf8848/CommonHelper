package com.kongpf.commonhelper;

/**
 * Created by pengf on 2018/2/28.
 */

public class ByteHelper {

    private static final String HEXSTRING = "0123456789ABCDEF";

    public static byte hexChar2Byte(char c) {
        return (byte) (HEXSTRING.indexOf(String.valueOf(c).toUpperCase()));
    }

    public static String byteToHex(int b) {
        char[] result = new char[2];
        result[0] = hexDigit((b >>> 4) & 0xf);
        result[1] = hexDigit(b & 0xf);
        return new String(result);
    }

    public static char hexDigit(int i) {
        return (char) (i < 10 ? i + '0' : i - 10 + 'a');
    }

    //字节数组转化为16进制字符串
    public static String byteArray2HexString(byte[] bArr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = bArr.length; i < len; i++) {
            builder.append(String.format("%02X", bArr[i]));
        }
        return builder.toString();
    }
    //16进制字符串转化为字节数组
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

    public static byte[] subBytes(byte[] data, int offset, int len) {
        if ((offset < 0) || (data.length <= offset)) {
            return null;
        }
        if ((len < 0) || (data.length < offset + len)) {
            len = data.length - offset;
        }
        byte[] ret = new byte[len];

        System.arraycopy(data, offset, ret, 0, len);
        return ret;
    }

    public static byte byteXOR(byte src1, byte src2) {
        return (byte) ((src1 & 0xFF) ^ (src2 & 0xFF));
    }

    public static byte[] bytesXOR(byte[] src1, byte[] src2) {
        int length = src1.length;
        if (length != src2.length) {
            return null;
        }
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = byteXOR(src1[i], src2[i]);
        }
        return result;
    }

}
