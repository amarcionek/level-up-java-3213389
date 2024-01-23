package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    /*
     * 6 chars, 1 upper, 1 lower, 1 number
     */
    public static boolean isPasswordComplex(String password) {

        return password.length() >= 6
                && password.matches(".*\\d.*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[A-Z].*");

        // boolean hasNumber = false;
        // boolean hasUpper = false;
        // boolean hasLower = false;

        // for (int i = 0; i < password.length(); i++) {
        // char ch = password.charAt(i);
        // if (Character.isDigit(ch)) {
        // hasNumber = true;
        // } else if (Character.isUpperCase(ch)) {
        // hasUpper = true;
        // } else if (Character.isLowerCase(ch)) {
        // hasLower = true;
        // }

        // if (hasNumber && hasUpper && hasLower)
        // return true;

        // }
        // return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
