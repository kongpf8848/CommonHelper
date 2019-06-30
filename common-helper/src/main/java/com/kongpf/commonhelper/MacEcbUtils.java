package com.kongpf.commonhelper;

public class MacEcbUtils {

    public static byte[] getMac(byte[] key, byte[] input) throws Exception {
        int length = input.length;
        int x = length % 8;

        int addLen = 0;
        if (x != 0) {
            addLen = 8 - length % 8;
        }
        int pos = 0;

        byte[] data = new byte[length + addLen];
        System.arraycopy(input, 0, data, 0, length);

        byte[] oper1 = new byte[8];
        System.arraycopy(data, pos, oper1, 0, 8);
        pos += 8;
        for (int i = 1; i < data.length / 8; i++) {
            byte[] oper2 = new byte[8];
            System.arraycopy(data, pos, oper2, 0, 8);
            byte[] t = ByteHelper.bytesXOR(oper1, oper2);
            oper1 = t;
            pos += 8;
        }

        byte[] resultBlock = ByteHelper.byteArray2HexString(oper1).getBytes();

        byte[] front8 = new byte[8];
        System.arraycopy(resultBlock, 0, front8, 0, 8);
        byte[] behind8 = new byte[8];
        System.arraycopy(resultBlock, 8, behind8, 0, 8);
        byte[] desfront8 = DesHelper.encrypt(front8, key);

        byte[] resultXOR = ByteHelper.bytesXOR(desfront8, behind8);

        byte[] buff = DesHelper.encrypt(resultXOR, key);

        String hex = ByteHelper.byteArray2HexString(buff);
        byte[] retBuf = new byte[8];
        System.arraycopy(hex.getBytes(), 0, retBuf, 0, 8);

        return retBuf;
    }




}

