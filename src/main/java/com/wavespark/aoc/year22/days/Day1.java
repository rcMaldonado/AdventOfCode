package com.wavespark.aoc.year22.days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    private static final String fileName = "year2022/day1.txt";

    public static void main(String[] args) {
        System.out.println("Day 1");
        Day1 app = new Day1();

        //Part 1
        System.out.println("getResourceAsStream : " + fileName);
        InputStream calorieStream = app.getFileFromResourceAsStream(fileName);
        List<Integer> elvesTotalHoldingCalories = app.readInputStream(calorieStream);

        int highestCalorieHolding = app.elfWithHighestCalorieHolding(elvesTotalHoldingCalories);
        System.out.println(highestCalorieHolding);

        //Part 2
        int sumOfThreeHoldingCalories = app.sumOfTopThreeCalorieHoldings(elvesTotalHoldingCalories);
        System.out.println(sumOfThreeHoldingCalories);
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    private List<Integer> readInputStream(InputStream is) {
        List<Integer> elvesHoldingCalories = new ArrayList<Integer>();

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(streamReader)) {
                int holdingCalories = 0;

                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.isEmpty() == true) {
                        elvesHoldingCalories.add(holdingCalories);
                        holdingCalories = 0;

                    } else {
                        int calories = Integer.parseInt(line);
                        holdingCalories += calories;
                    }
                }


            } catch(IOException e){
                e.printStackTrace();
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
