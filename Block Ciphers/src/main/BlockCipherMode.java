package main;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class BlockCipherMode {

    // Experimenting with CBC mode

    SecretKeySpec secretKeySpec;
    IvParameterSpec ivParameterSpec;

    public BlockCipherMode(String key) throws NoSuchAlgorithmException{
        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        ivParameterSpec = new IvParameterSpec(iv);

        // 16 bytes key generation using hash function
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(key.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        secretKeySpec = new SecretKeySpec(keyBytes, "AES");
    }

    public byte[] encrypt(String messsage) throws InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchPaddingException,
            NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException {

        byte[] msgBytes = messsage.getBytes();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        return  cipher.doFinal(msgBytes);
    }

    public byte[] decrypt(byte[] encrypted) throws BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(encrypted);
    }
}
