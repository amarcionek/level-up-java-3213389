package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

  private Random ladyLuck = new Random(); // create Random object ladyLuck

  public void playGame() {
    int points = 10;
    Scanner scanner = new Scanner(System.in);

    while (points > 0) {
      System.out.printf("Current points: %d, double or nothing? (Y/N)\n", points);
      String userInput = scanner.nextLine();
      if (userInput.matches("[Nn]"))
        break;
      if (userInput.matches("[Yy]"))
        points = doublePoints(points);
    }

    System.out.printf("Ended with points: %d\n", points);

    scanner.close();
  }

  private int doublePoints(int points) {

    if (ladyLuck.nextInt(10) >= 3) {
      System.out.printf("You doubled your points to %d!\n", points * 2);
      return points * 2;
    }
    System.out.printf("Sorry, you lose!\n");
    return 0;

  }
}