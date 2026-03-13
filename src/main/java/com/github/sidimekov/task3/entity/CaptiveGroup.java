package com.github.sidimekov.task3.entity;

import java.util.ArrayList;
import java.util.List;

public class CaptiveGroup {

    private List<Prisoner> prisoners = new ArrayList<>();

    public void addPrisoner(Prisoner prisoner) {
        prisoners.add(prisoner);
    }

    public int totalFear() {
        double sum = 0;
        for (Prisoner p : prisoners) {
            sum += p.getFearLevel();
        }
        return (int) sum;
    }

    public List<Prisoner> getPrisoners() {
        return prisoners;
    }
}