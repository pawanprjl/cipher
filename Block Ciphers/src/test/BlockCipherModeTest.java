package test;

import main.BlockCipherMode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlockCipherModeTest {
    String text = "Quick brown fox jumped upon the lazy rock";
    String keyword = "password";
    byte[] decrypted;

    @Test
    public void DesTest(){
        try{
            BlockCipherMode blockCipherMode = new BlockCipherMode(keyword);
            byte[] encrypted = blockCipherMode.encrypt(text);
            decrypted = blockCipherMode.decrypt(encrypted);
        }catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(text,new String(decrypted));
    }

}