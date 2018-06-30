package com.kongpf.commonhelper;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DesHelper {

    private final static String DES = "DES";
    private final static String CIPHER_ALGORITHM = "DES/ECB/NoPadding";

    public static byte[] initKey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(DES);
        kg.init(16);
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }

    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        try {
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static byte[] decrypt(byte[] src, byte[] key) {
        SecureRandom sr = new SecureRandom();
        try {
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
            return cipher.doFinal(src);
        } catch (Exception e) {
        }
        return null;
    }

}