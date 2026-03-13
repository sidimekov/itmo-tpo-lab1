package com.github.sidimekov.task3.entity;

import com.github.sidimekov.task3.emotion.EmotionState;
import com.github.sidimekov.task3.shoutEvent.Event;

public abstract class Human {

    protected String name;
    protected EmotionState emotion;

    public Human(String name, EmotionState emotion) {
        this.name = name;
        this.emotion = emotion;
    }

    public String getName() {
        return name;
    }

    public EmotionState getEmotion() {
        return emotion;
    }

    public void setEmotion(EmotionState emotion) {
        this.emotion = emotion;
    }

    public abstract void reactToEvent(Event event);
}