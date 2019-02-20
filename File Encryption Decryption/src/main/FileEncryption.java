package main;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncryption {
    public static final String ALGORITHM = "AES";
    SecretKeySpec aesKey;

    public FileEncryption(String key){
        aesKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
    }

    public void encrypt( File inputFile, File outputFile)
            throws EncryptionException {
        doEncryption(Cipher.ENCRYPT_MODE, inputFile, outputFile);
    }

    public void decrypt(File inputFile, File outputFile)
            throws EncryptionException {
        doEncryption(Cipher.DECRYPT_MODE, inputFile, outputFile);
    }

    public void doEncryption(int cipherMode, File inputFile, File outputFile) throws EncryptionException {
        try{
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(cipherMode, aesKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);
            inputStream.close();
            outputStream.close();
        }catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException e){
            throw new EncryptionException("Error during encryption/decryption", e);
        }
    }
}
