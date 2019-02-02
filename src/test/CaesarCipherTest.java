package test;

import main.CaesarCipher;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {


    CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    public void encrypt() {
        String plainText = "ABcd";
        String encoded = "CDef";
        assertEquals(encoded, caesarCipher.encrypt(plainText, 2));
    }

    @Test
    public void decrypt() {
        String plainText = "ABcd";
        String encoded = "CDef";
        assertEquals(plainText, caesarCipher.decrypt(encoded, 2));
    }
}