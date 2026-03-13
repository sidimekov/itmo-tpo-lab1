package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.emotion.MuscleSequence;
import com.github.sidimekov.task3.shoutEvent.Event;
import com.github.sidimekov.task3.shoutEvent.ShoutEvent;

public class Vogon extends Human {

    private double smileSpeed;
    private int shoutPower;

    public Vogon(String name, EmotionState emotion, double smileSpeed, int shoutPower) {
        super(name, emotion);
        this.smileSpeed = smileSpeed;
        this.shoutPower = shoutPower;
    }

    public double calculateSmileTime(MuscleSequence sequence) {
        return sequence.getComplexity() / smileSpeed;
    }

    public void shoutAt(Prisoner prisoner) {
        ShoutEvent event = new ShoutEvent(this, shoutPower);
        event.execute(prisoner);
    }

    public void refresh() {
        emotion = new EmotionState("refreshed", 1);
    }

    @Override
    public void reactToEvent(Event event) {
        event.execute(this);
    }
}