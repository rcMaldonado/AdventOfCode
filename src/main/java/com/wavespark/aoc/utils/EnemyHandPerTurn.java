package com.wavespark.aoc.utils;

public enum EnemyHandPerTurn {
    ROCK('A'),PAPER('B'),SCISSORS('C');

    private char action;

    // getter method
    public char getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private EnemyHandPerTurn(char action)
    {
        this.action = action;
    }
}
