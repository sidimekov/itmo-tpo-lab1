package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.shoutEvent.Event;

public class Prisoner extends Human {

    private double fearLevel;

    public Prisoner(String name, EmotionState emotion) {
        super(name, emotion);
    }

    public void receiveShout(int power) {

        double fearIncrease = Math.pow(power, 2) / 10.0;

        fearLevel += fearIncrease;

        emotion.increaseIntensity(power);
    }

    public double getFearLevel() {
        return fearLevel;
    }

    @Override
    public void reactToEvent(Event event) {
        event.execute(this);
    }
}