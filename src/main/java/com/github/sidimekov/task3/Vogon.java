package com.github.sidimekov.task3;

public class Vogon extends Human {
    private double smileSpeed;

    public Vogon(String mood, double smileSpeed) {
        super(mood);
        this.smileSpeed = smileSpeed;
    }

    public double getSmileSpeed() {
        return smileSpeed;
    }

    public void refresh() {
        this.mood = "refreshed";
    }

    public void shoutAt(Prisoner prisoner) {
        prisoner.setShoutedAt(true);
    }
}