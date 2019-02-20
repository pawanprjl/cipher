package test;

import main.EncryptionException;
import main.FileEncryption;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileEncryptionTest {

    @Test
    public void fileEncryptionTest() throws IOException {
        String key = "0123456789abcdef";
        FileEncryption fileEncryption = new FileEncryption(key);
        File inputFile = new File("src/test/document.txt");
        File encryptedFile = new File("src/test/encrypted.txt");
        File decryptedFile = new File("src/test/decrypted.txt");

        try {
            fileEncryption.encrypt(inputFile, encryptedFile);
            fileEncryption.decrypt(encryptedFile, decryptedFile);
        } catch (EncryptionException e) {
            e.printStackTrace();
        }

        FileInputStream inputFileStream = new FileInputStream(inputFile);
        FileInputStream decrypted = new FileInputStream(decryptedFile);
        assertEquals(inputFileStream.read(), decrypted.read());
    }
}