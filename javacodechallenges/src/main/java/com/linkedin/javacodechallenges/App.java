package com.linkedin.javacodechallenges;

import java.util.List;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        // if (purchases.size() == 0) {
        // return 0;
        // }
        // Double totalSaved = purchases.stream().reduce(0.0, (a, b) -> (a +
        // (Math.ceil(b) - b)));
        // return totalSaved / purchases.size();

        return purchases.stream().mapToDouble(d -> Math.ceil(d) - d).average().orElse(0);
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
