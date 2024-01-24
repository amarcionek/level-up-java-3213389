package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class App {
    // Create function to calculate the date that's
    // 100 days from now
    public static LocalDate hundredDaysFromNow(LocalDate today) {
        Period hundredDays = Period.ofDays(100);
        return today.plus(hundredDays);
    }

    public static void main(String[] args) {

        LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));
        System.out.println("100 days from now is... " + hundredDaysFromNow(today));
    }
}
