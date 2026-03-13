package com.github.sidimekov.task3.emotion;

public class EmotionState {

    private String value;
    private double intensity;

    public EmotionState(String value, double intensity) {
        this.value = value;
        this.intensity = intensity;
    }

    public String getValue() {
        return value;
    }

    public double getIntensity() {
        return intensity;
    }

    public void increaseIntensity(int amount) {
        intensity += Math.log1p(amount);
    }
}