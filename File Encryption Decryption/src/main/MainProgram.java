package main;

import java.io.File;
import java.util.Scanner;

public class MainProgram {

    public static void main(String []args){
        String key = "1234567890abcdef", inputFileName, outputFileName;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the path to the file");
        inputFileName = input.nextLine();
        File inputFile = new File(inputFileName);

        System.out.println("Enter the path to the output file");
        outputFileName = input.nextLine();
        File outputFile = new File(outputFileName);

        FileEncryption encryption = new FileEncryption(key);
        try {
            encryption.decrypt(inputFile, outputFile);
        } catch (EncryptionException e) {
            e.printStackTrace();
        }
    }
}
