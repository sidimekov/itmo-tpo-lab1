package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.event.Event;
import com.github.sidimekov.task3.event.ShoutEvent;

public class Vogon extends Human {
    private double smileSpeed;
    private int shoutPower;

    public Vogon(String name, String mood, double smileSpeed, int shoutPower) {
        super(name, mood);
        this.smileSpeed = smileSpeed;
        this.shoutPower = shoutPower;
    }

    public double getSmileSpeed() {
        return smileSpeed;
    }

    public int getShoutPower() { return shoutPower; }

    public void refresh() {
        this.mood = "refreshed";
    }

    public void shoutAt(Prisoner prisoner) {
        ShoutEvent event = new ShoutEvent(this, shoutPower);
        event.execute(prisoner);
    }

    @Override
    public void reactToEvent(Event event) {
        event.execute(this);
    }
}