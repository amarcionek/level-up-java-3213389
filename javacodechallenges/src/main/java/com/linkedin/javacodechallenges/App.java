package com.linkedin.javacodechallenges;

public class App {
    public static void main(String[] args) {
        Person adam = new Person("Adam", "Marcionek");
        Person dan = new Person("Dan", "Marino");

        System.out.printf("%s\n", adam.getGreeting());
        System.out.printf("%s\n", dan.getGreeting());
    }
}
