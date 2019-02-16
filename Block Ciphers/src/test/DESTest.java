package test;

import main.DES;
import org.junit.Test;

import static org.junit.Assert.*;

public class DESTest {

    String text = "Quick brown fox jumped upon the lazy rock";
    String keyword = "password";
    byte[] decrypted;

    @Test
    public void DesTest(){
        DES des = new DES(keyword);
        try{
            byte[] encrypted = des.encrypt(text.getBytes());
            decrypted = des.decrypt(encrypted);
        }catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(text,new String(decrypted));
    }

}