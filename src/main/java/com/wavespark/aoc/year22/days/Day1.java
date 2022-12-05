package com.wavespark.aoc.year22.days;

import com.wavespark.aoc.utils.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    private static final String fileName = "day1.txt";

    public static void main(String[] args) {
        System.out.println("Day 1");
        FileReader fileReader = new FileReader();
        Day1 app = new Day1();

        //Part 1
        System.out.println("getResourceAsStream : " + fileName);
        InputStream calorieStream = fileReader.getFileFromResourceAsStream(fileName);
        List<String> calorieContent = fileReader.ReadFileContent(calorieStream);
        List<Integer> elvesTotalHoldingCalories = app.calculateTotalCaloriesPerElf(calorieContent);

        int highestCalorieHolding = app.elfWithHighestCalorieHolding(elvesTotalHoldingCalories);
        System.out.println(highestCalorieHolding);

        //Part 2
        int sumOfThreeHoldingCalories = app.sumOfTopThreeCalorieHoldings(elvesTotalHoldingCalories);
        System.out.println(sumOfThreeHoldingCalories);
    }

    private List<Integer> calculateTotalCaloriesPerElf(List<String> calorieContent) {
        List<Integer> elvesHoldingCalories = new ArrayList<Integer>();

        int holdingCalories = 0;

        for(String calories: calorieContent) {
            if(calories.isEmpty() == true) {
                elvesHoldingCalories.add(holdingCalories);
                holdingCalories = 0;

            } else {
                int elfCalories = Integer.parseInt(calories);
                holdingCalories += elfCalories;
            }
        }

        return elvesHoldingCalories;
    }

    private int elfWithHighestCalorieHolding(List<Integer> elvesTotalHoldingCalories) {
        Collections.sort(elvesTotalHoldingCalories);

        int highestHolding = elvesTotalHoldingCalories.get(elvesTotalHoldingCalories.size()-1);
        return highestHolding;
    }

    private int sumOfTopThreeCalorieHoldings(List<Integer> elvesTotalHoldingCalories) {
        int sumOfThree = 0;
        for (int i = 1; i <= 3; i++) {
            sumOfThree += elvesTotalHoldingCalories.get(elvesTotalHoldingCalories.size()-i);
        }

        return sumOfThree;
    }
}
