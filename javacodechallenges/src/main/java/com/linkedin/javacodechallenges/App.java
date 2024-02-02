package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class App {
    public static void redactTextFile(String fileName,
            String[] redactedWordsArray) {

        File fileRead = new File(fileName);
        File fileWrite = new File(fileName + "new");
        Scanner reader = null;
        FileWriter myWriter = null;
        try {
            reader = new Scanner(fileRead);
            myWriter = new FileWriter(fileWrite);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                // Watch for commas in words
                for (String redacted : redactedWordsArray) {
                    line = StringUtils.replaceIgnoreCase(line, redacted, "REDACTED");
                }
                myWriter.write(line + "\n");
            }
            myWriter.flush();

        } catch (Exception e) {
            if (reader != null)
                reader.close();

            if (myWriter != null)
                try {
                    myWriter.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
