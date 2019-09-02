package com.kongpf.commonhelper;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper {
    private static final String TAG = "AESHelper";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    //加密
    public static String encryptBase64(String data, String key) {
        Objects.requireNonNull(data);
        Objects.requireNonNull(key);
        byte[] bData = crypt(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8), null,Cipher.ENCRYPT_MODE);
        String base64String = null;
        if (bData != null && bData.length > 0) {
            base64String = Base64.encodeToString(bData, Base64.NO_WRAP);
        }
        return base64String;
    }

    //解密
    public static String decryptBase64(String base64String, String key) {
        Objects.requireNonNull(base64String);
        Objects.requireNonNull(key);
        byte[]bBase64=Base64.decode(base64String,Base64.NO_WRAP);
        byte[] bData = crypt(bBase64, key.getBytes(StandardCharsets.UTF_8), null,Cipher.DECRYPT_MODE);
        String content = null;
        if (bData != null && bData.length > 0) {
            content =new String(bData,StandardCharsets.UTF_8);
        }
        return content;
    }

    private static byte[] crypt(byte[] data, byte[] key, byte[] iv,int mode) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            if (iv != null && iv.length != 0) {
                AlgorithmParameterSpec params = new IvParameterSpec(iv);
                cipher.init(mode, secretKey, params);
            } else {
                cipher.init(mode, secretKey);
            }
            byte[] bData = cipher.doFinal(data);
            return bData;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;

    }
}

