package main;

public class MonoAlphabeticCipher {
//    public static char plain[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
//            'H', 'I', 'J', 'K', 'L','M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//
//    public static char cipher[] = {'H', 'T', 'K', 'C', 'U', 'O', 'I', 'S', 'J', 'Y',
//            'A', 'R', 'G', 'M', 'Z', 'N', 'B', 'V', 'F', 'P', 'X', 'D', 'L', 'W', 'Q', 'E'};

    private static String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String cipher = "HTKCUOISJYARGMZNBVFPXDLWQE";

    public static String encrypt(String text){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<text.length();i++){
            int index = plain.indexOf(text.charAt(i));
            char ch = cipher.charAt(index);
            stringBuffer.append(ch);
        }
        return  stringBuffer.toString();
    }

    public static String decrypt(String text){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<text.length();i++){
            char ch = plain.charAt(cipher.indexOf(text.charAt(i)));
            stringBuffer.append(ch);
        }
        return  stringBuffer.toString();
    }
}
