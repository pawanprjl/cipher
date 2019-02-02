public class CaesarCipher {

    public static String encrypt(String text, int key){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < text.length(); i++){
            if(Character.isUpperCase(text.charAt(i))){
                // converting a char into its equivalent order in alphabet with shift checking if
                // it exceeds 26 letters and then restoring it to the original alphabet
                char ch = (char) (((int) text.charAt(i) + key - 65)%26 + 65);
                stringBuffer.append(ch);
            }else{
                char ch = (char) (((int) text.charAt(i) + key - 97)%26 + 97);
                stringBuffer.append(ch);
            }
        }

        return stringBuffer.toString();
    }

    public static String decrypt(String encoded, int key){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < encoded.length(); i++){
            if(Character.isUpperCase(encoded.charAt(i))){
                // here character is shifted back by key value for decrypting text
                char ch = (char) (((int) encoded.charAt(i) - key - 65)%26 + 65);
                stringBuffer.append(ch);
            }else{
                char ch = (char) (((int) encoded.charAt(i) - key - 97)%26 + 97);
                stringBuffer.append(ch);
            }
        }
        return  stringBuffer.toString();
    }
}
