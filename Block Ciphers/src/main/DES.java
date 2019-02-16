package main;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class DES {

    SecretKeySpec desKey;
    public DES(String key) {
        desKey = new SecretKeySpec(key.getBytes(), "DES");
    }

    public byte[] encrypt(byte[] message) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        return desCipher.doFinal(message);
    }

    public byte[] decrypt(byte[] encrypted) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.DECRYPT_MODE, desKey);
        return desCipher.doFinal(encrypted);
    }
}
