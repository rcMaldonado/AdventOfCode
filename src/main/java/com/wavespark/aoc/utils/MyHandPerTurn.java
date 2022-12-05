package com.wavespark.aoc.utils;

public enum MyHandPerTurn {
    ROCK('X'),PAPER('Y'),SCISSORS('Z');

    private char action;

    // getter method
    public char getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private MyHandPerTurn(char action)
    {
        this.action = action;
    }
}
