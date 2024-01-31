package com.linkedin.javacodechallenges;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  // // Print final score in descending order and print the winner.
  // public static void revealResults(List<Team> teams) {

  // if (teams.size() == 0 || teams.stream().allMatch(t ->
  // t.getScores().isEmpty())) {
  // System.out.println("The game hasn't started yet.");
  // }

  // NOTE: THIS IS AN IMMUTABLE LIST! Also doesn't deal with ties.
  // teams.sort((t1, t2) ->
  // Integer.valueOf(t2.sumTotalScore()).compareTo(Integer.valueOf(t1.sumTotalScore())));

  // System.out.println("Now for the results, the WINNER is...");
  // boolean first = true;
  // for (Team t : teams) {
  // if (!first) {
  // System.out.println("Then we have... ");
  // }
  // first = false;
  // System.out.printf("With %d points, it's team %s and %s!\n\n",
  // t.sumTotalScore(), t.getPlayer1(), t.getPlayer2());
  // }
  // }

  public static void revealResults(List<Team> teams) {

    if (teams.size() == 0 || teams.stream()
        .allMatch(team -> team.getScores().isEmpty())) {
      System.out.println("The game hasn't started yet.");
      return;
    }

    TreeMap<Integer, List<Team>> scoreTeamsMap = teams.stream()
        .collect(Collectors.groupingBy(Team::sumTotalScore,
            TreeMap::new, Collectors.toList()));
    Iterator<Integer> scoreResultsIterator = scoreTeamsMap.descendingKeySet()
        .stream()
        .iterator();

    System.out.println("Now for the results, the WINNER is...");
    announceResult(scoreResultsIterator.next(), scoreTeamsMap);

    while (scoreResultsIterator.hasNext()) {
      System.out.println("Then we have... ");
      announceResult(scoreResultsIterator.next(), scoreTeamsMap);
    }
  }

  private static void announceResult(int score,
      TreeMap<Integer, List<Team>> scoreTeamsMap) {

    List<Team> playersWithScore = scoreTeamsMap.get(score);

    if (playersWithScore.size() > 1) {
      System.out.println("It's a TIE!");
    }

    playersWithScore
        .forEach(team -> System.out.println("With " + score +
            " points, it's team " + team.getPlayer1() + " and " +
            team.getPlayer2() + "!"));

    System.out.println();
  }
}