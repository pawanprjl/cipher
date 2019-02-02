package main;

public class MainProgram {

    public static void main(String []args){

        String plainText = "BlockChain";
        String encoded;

        System.out.println("Caesar Cipher: \n");

        // Caesar cipher
        CaesarCipher caesarCipher = new CaesarCipher();
        encoded = caesarCipher.encrypt(plainText, 4);
        System.out.println("Encoded: "+encoded);

        String decrypted = caesarCipher.decrypt(encoded, 4);
        System.out.println("Decoded: "+decrypted);

        // Vigenere cipher
        System.out.println("/nVigenere Cipher: \n");

        VigenereCipher vigenereCipher = new VigenereCipher();
        encoded = vigenereCipher.encrypt(plainText, "pawan");
        System.out.println("Encoded: "+encoded);

        decrypted = vigenereCipher.decrypt(encoded, "pawan");
        System.out.println("Decoded: "+decrypted);


        // MonoAlphabetic cipher
        System.out.println("/nMonoAlphabetic Cipher: \n");

        MonoAlphabeticCipher monoAlphabeticCipher = new MonoAlphabeticCipher();
        encoded = monoAlphabeticCipher.encrypt("PAWAN");
        System.out.println("Encoded: "+encoded);

        decrypted = monoAlphabeticCipher.decrypt(encoded);
        System.out.println("Decoded: "+decrypted);
    }
}
