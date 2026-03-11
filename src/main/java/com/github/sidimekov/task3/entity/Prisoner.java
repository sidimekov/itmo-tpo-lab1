package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.event.Event;

public class Prisoner extends Human {
    private int fearLevel = 0;

    public Prisoner(String name, String mood) {
        super(mood, name);
    }

    public void receiveShout(int power) {
        fearLevel += power;
        this.mood = "scared";
    }

    public int getFearLevel() { return fearLevel; }

    @Override
    public void reactToEvent(Event event) {
        event.execute(this);
    }
}
