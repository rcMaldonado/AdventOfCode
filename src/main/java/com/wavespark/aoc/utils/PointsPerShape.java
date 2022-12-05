package com.wavespark.aoc.utils;

public enum PointsPerShape {
    ROCK(1),PAPER(2),SCISSORS(3);

    private int action;

    // getter method
    public int getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private PointsPerShape(int action)
    {
        this.action = action;
    }
}
