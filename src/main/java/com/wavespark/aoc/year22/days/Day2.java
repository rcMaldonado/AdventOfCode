package com.wavespark.aoc.year22.days;

import com.wavespark.aoc.utils.*;

import java.util.List;

public class Day2 {
    private static final String fileName = "day2.txt";
    public static void main(String[] args) {
        System.out.println("Day 2");
        var app = new Day2();
        var fileReader = new FileReader();

        var fileStream = fileReader.getFileFromResourceAsStream(fileName);
        var fileContent = fileReader.ReadFileContent(fileStream);

        System.out.println("Shape Point: " + PointsPerShape.ROCK.getAction());
    }

    private int calculateTotalPoints(List<String> tournamentCheatSheet) {
        var totalPoints = 0;

        for (var i = 0; i < tournamentCheatSheet.size(); i++){

        }


        return 0;
    }

    private Outcome decideOutcome(char enemyHand, char myHand) {

        return Outcome.DRAW;
    }

}
