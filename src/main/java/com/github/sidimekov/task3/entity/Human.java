package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.event.Event;

public abstract class Human {
    protected String mood;
    protected String name;

    public Human(String mood, String name) {
        this.mood = mood;
        this.name = name;
    }

    public String getMood() {
        return mood;
    }
    public String getName() { return name; }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public abstract void reactToEvent(Event event);
}
