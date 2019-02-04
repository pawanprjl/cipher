package main;

public class VigenereCipher {

    public static String encrypt(String text, String key){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0, j = 0; i< text.length(); i++){
            if(Character.isUpperCase(text.charAt(i))){
                char ch = (char) (((int)text.charAt(i) + (int)key.charAt(j) -2*65) % 26 + 65);
                stringBuffer.append(ch);
            }else{
                char ch = (char) (((int)text.charAt(i) + (int)key.charAt(j) - 2*97) % 26 + 97);
                stringBuffer.append(ch);
            }
            j++;
            j = j%key.length();
        }
        return stringBuffer.toString();
    }

    public static String decrypt(String text, String key){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0, j = 0; i< text.length(); i++){
            if(Character.isUpperCase(text.charAt(i))){
                char ch = (char) (((int)text.charAt(i) - (int)key.charAt(j) + 26) % 26 + 65);
                stringBuffer.append(ch);
            }else{
                char ch = (char) (((int)text.charAt(i) - (int)key.charAt(j) + 26) % 26 + 97);
                stringBuffer.append(ch);
            }
            j++;
            j = j%key.length();
        }
        return stringBuffer.toString();
    }
}
