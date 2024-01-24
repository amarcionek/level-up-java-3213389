package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    // Min charge 18.84 for 1496 gallows (2 CCFs)
    // One CCF = 748 gallons
    // > 2 CCFs, + 3.90 per additional CCF
    public static double calculateWaterBill(double gallonsUsage) {

        double perCCF = 18.84 / 2;
        double cost = 2 * perCCF;

        double numCCFs = Math.ceil(gallonsUsage / 748);

        if (numCCFs > 2) {
            cost += (numCCFs - 2) * 3.90;
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
