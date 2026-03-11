package com.github.sidimekov.task3;

import java.util.List;

public class ShoutSeries {
    private final int duration;

    public ShoutSeries(int duration) {
        this.duration = duration;
    }

    public void execute(Vogon vogon, List<Prisoner> prisoners) {
        for (int i = 0; i < duration; i++) {
            for (Prisoner p : prisoners) {
                vogon.shoutAt(p);
            }
        }
    }
}
