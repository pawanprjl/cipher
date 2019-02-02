package test;

import main.MonoAlphabeticCipher;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonoAlphabeticCipherTest {

    MonoAlphabeticCipher monoAlphabeticCipher = new MonoAlphabeticCipher();
    @Test
    public void encrypt() {
        String plain = "CIPHER";
        String encoded = "KJNSUV";
        assertEquals(encoded, monoAlphabeticCipher.encrypt(plain));
    }

    @Test
    public void decrypt() {

        String plain = "CIPHER";
        String encoded = "KJNSUV";
        assertEquals(plain, monoAlphabeticCipher.decrypt(encoded));
    }
}