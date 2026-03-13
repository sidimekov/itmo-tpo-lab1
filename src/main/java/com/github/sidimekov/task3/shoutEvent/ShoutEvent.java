package com.github.sidimekov.task3.shoutEvent;

import com.github.sidimekov.task3.entity.Human;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;

public class ShoutEvent implements Event {

    private Vogon source;
    private int power;

    public ShoutEvent(Vogon source, int power) {
        this.source = source;
        this.power = power;
    }

    @Override
    public void execute(Human target) {
        if(target instanceof Prisoner prisoner) {
            prisoner.receiveShout(power);
        }

    }
}