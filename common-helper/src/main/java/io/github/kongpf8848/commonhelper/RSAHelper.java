package io.github.kongpf8848.commonhelper;

import android.content.Context;
import android.support.annotation.IntDef;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAHelper {

    private static final String ALGORITHM = "RSA";
    private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static final List<String> excludeList = new ArrayList<String>();
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;
    public static final int RSA_KEY_PUBLIC = 1;
    public static final int RSA_KEY_PRIVATE = 2;

    @IntDef({RSA_KEY_PUBLIC, RSA_KEY_PRIVATE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface KeyType {
    }

    static {
        excludeList.add("-----BEGIN PUBLIC KEY-----");
        excludeList.add("-----BEGIN PRIVATE KEY-----");
        excludeList.add("\r");
        excludeList.add("\n");
        excludeList.add("-----END PUBLIC KEY-----");
        excludeList.add("-----END PRIVATE KEY-----");
    }

    //从Asset中加载公钥和私钥
    public static Key loadKeyFromAsset(Context context, String filename, @KeyType int type) {
        try {
            String pem = StreamHelper.toString(context.getAssets().open(filename));
            if (!TextUtils.isEmpty(pem)) {
                for (String target : excludeList) {
                    pem = pem.replace(target, "");
                }
                switch (type) {
                    case RSA_KEY_PUBLIC:
                        return loadPublicKey(pem);
                    case RSA_KEY_PRIVATE:
                        return loadPrivateKey(pem);
                    default:
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    //从字符串获取RSA公钥
    public static PublicKey loadPublicKey(String pem) {
        byte[] bKey = Base64.decode(pem, Base64.NO_WRAP);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bKey);
        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance(ALGORITHM).generatePublic(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    //从字符串获取RSA私钥
    public static PrivateKey loadPrivateKey(String pem) {
        byte[] bKey = Base64.decode(pem, Base64.NO_WRAP);
        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(bKey);
        PrivateKey privateKey = null;
        try {
            privateKey = KeyFactory.getInstance(ALGORITHM).generatePrivate(privKeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return privateKey;

    }

    //RSA加密
    public static String encrypt(String content,Key key) {
        try {
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            int length = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (int i = 0; i < data.length; i += MAX_ENCRYPT_BLOCK) {
                if (i + MAX_ENCRYPT_BLOCK > data.length) {
                    length = data.length - i;
                } else {
                    length = MAX_ENCRYPT_BLOCK;
                }
                byte[] b = cipher.doFinal(data, i, length);
                bos.write(b);
            }
            byte[] bAll = bos.toByteArray();
            bos.close();
            return Base64.encodeToString(bAll, Base64.NO_WRAP);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //RSA解密
    public static String decrypt(String content, Key key) {
        try {
            byte[] data = Base64.decode(content, Base64.NO_WRAP);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, key);
            int length = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (int i = 0; i < data.length; i += MAX_DECRYPT_BLOCK) {
                if (i + MAX_DECRYPT_BLOCK > data.length) {
                    length = data.length - i;
                } else {
                    length = MAX_DECRYPT_BLOCK;
                }
                byte[] b = cipher.doFinal(data, i, length);
                bos.write(b);
            }
            byte[] bAll = bos.toByteArray();
            bos.close();
            return new String(bAll, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //签名
    public static String sign(String data,String algorithm,PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeToString(signature.sign(), Base64.NO_WRAP);
    }

    //验签
    public static boolean verify(String data,String algorithm,String sign,PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.decode(sign.getBytes(StandardCharsets.UTF_8),Base64.NO_WRAP));
    }
}
