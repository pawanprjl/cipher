package main;

public class MainProgram {

    public static void main(String []args){

        String message = "Quick brown fox jumped upon the lazy dog";
        String aesKey = "0123456789asdfgh";
        String macKey = "can be of any bits but must be strong";

        String hmacValue;
        byte[] encrypted;

        AES aes = new AES(aesKey);
        HMAC hmac = new HMAC(macKey);

        try {
            encrypted = aes.encrypt(message.getBytes());
            hmacValue = hmac.generateMACString(message);
            System.out.println("Encrypted message: "+ encrypted + "\n" + "HMAC: "+ hmacValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
