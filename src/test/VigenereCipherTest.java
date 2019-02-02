package test;

import main.VigenereCipher;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereCipherTest {

    VigenereCipher vigenereCipher = new VigenereCipher();

    @Test
    public void encrypt() {
        String plainText = "GEEK";
        String key = "AYUSH";
        String encoded = "GCYC";
        assertEquals(encoded, vigenereCipher.encrypt(plainText, key));
    }

    @Test
    public void decrypt() {
        String plainText = "GEEK";
        String key = "AYUSH";
        String encoded = "GCYC";
        assertEquals(plainText, vigenereCipher.decrypt(encoded, key));
    }
}