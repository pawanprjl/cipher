package main;

public class MainProgram {

    public static void main(String []args){

        String text = "Quick brown fox jumped upon the lazy rock";
        String keyword = "password";
        byte[] encrypted = new byte[0];

        DES des = new DES(keyword);
        try {
            encrypted = des.encrypt(text.getBytes());
            System.out.println("Encrypted message: "+ new String(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            byte[] decrypted = des.decrypt(encrypted);
            System.out.print("Plain message: " + new String(decrypted));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
