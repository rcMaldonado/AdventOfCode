package com.wavespark.aoc.utils;

public enum PointsPerOutcome {
    LOST(0), DRAW(3), WIN(6);

    private int action;

    // getter method
    public int getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private PointsPerOutcome(int action)
    {
        this.action = action;
    }
}
