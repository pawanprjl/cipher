package main;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {
    SecretKeySpec aesKey;

    public AES(String key){
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
    }

    public byte[] encrypt(byte[] message) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return doEncryption(Cipher.ENCRYPT_MODE,message,aesKey);
    }

    public byte[] decrypt(byte[] encrypted) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return doEncryption(Cipher.DECRYPT_MODE,encrypted,aesKey);
    }

    public byte[] doEncryption(int cipherMode,byte[] message, SecretKeySpec aesKey) throws InvalidKeyException,
            NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException{
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(cipherMode, aesKey);
        return aesCipher.doFinal(message);
    }
}
