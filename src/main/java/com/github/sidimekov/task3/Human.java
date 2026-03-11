package com.github.sidimekov.task3;

public abstract class Human {
    protected String mood;

    public Human(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
