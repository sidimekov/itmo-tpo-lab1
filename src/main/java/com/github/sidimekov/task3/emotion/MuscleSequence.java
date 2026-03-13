package com.github.sidimekov.task3.emotion;

public class MuscleSequence {

    private boolean remembered;
    private int complexity;

    public MuscleSequence(boolean remembered, int complexity) {
        this.remembered = remembered;
        this.complexity = complexity;
    }

    public boolean isRemembered() {
        return remembered;
    }

    public int getComplexity() {
        return complexity;
    }

    public double getErrorProbability() {
        return complexity / 100.0;
    }
}