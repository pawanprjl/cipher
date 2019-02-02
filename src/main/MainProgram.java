package main;

public class MainProgram {

    public static void main(String []args){

        String plainText = "BlockChain";
        String encoded;

        // Caesar cipher
        CaesarCipher caesarCipher = new CaesarCipher();
        encoded = caesarCipher.encrypt(plainText, 4);
        System.out.println("Encoded: "+encoded);

        String decrypted = caesarCipher.decrypt(encoded, 4);
        System.out.println("Decoded: "+decrypted);
    }
}
