package test;

import main.AES;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import static org.junit.Assert.*;

public class AESTest {

    String text = "Quick brown fox jumped upon the lazy rock";
    String keyword = "0123456789abcdef";
    byte[] decrypted;

    @Test
    public void AESTest(){
        AES aes = new AES(keyword);
        try{
            byte[] encrypted = aes.encrypt(text.getBytes());
            System.out.println(new BASE64Encoder().encode(encrypted));
            decrypted = aes.decrypt(encrypted);
        }catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(text,new String(decrypted));
    }
}