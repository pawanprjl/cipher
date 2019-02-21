package test;

import main.AES;
import main.HMAC;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageAuthenticationTest {

    String message = "Quick brown fox jumped upon the lazy dog";
    String aesKey = "0123456789asdfgh"; // should be of 16 bytes
    String macKey = "can be of any bits but must be strong";

    @Test
    public void MessageAuthenticationTest(){
        HMAC hmac = new HMAC(macKey);
        AES aes = new AES(aesKey);
        byte[] encrypted;
        String hmacValue;
        byte[] decrypted;
        String finalHmacValue;

        try{
            encrypted = aes.encrypt(message.getBytes());
            hmacValue = hmac.generateMACString(message);
            decrypted = aes.decrypt(encrypted);
            finalHmacValue = hmac.generateMACString(new String(decrypted));
            assertEquals(hmacValue, finalHmacValue);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}