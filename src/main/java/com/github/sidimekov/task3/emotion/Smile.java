package com.github.sidimekov.task3.emotion;

import com.github.sidimekov.task3.entity.Vogon;

public class Smile {

    private Vogon owner;
    private double speed;
    private MuscleSequence sequence;

    public Smile(Vogon owner, double speed, MuscleSequence sequence) {
        this.owner = owner;
        this.speed = speed;
        this.sequence = sequence;
    }

    public double getSpeed() {
        return speed;
    }

    public MuscleSequence getSequence() {
        return sequence;
    }
}