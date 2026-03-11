package com.github.sidimekov.task3.event;

import com.github.sidimekov.task3.entity.Human;
import com.github.sidimekov.task3.entity.Prisoner;
import com.github.sidimekov.task3.entity.Vogon;

public class ShoutEvent implements Event {
    private Vogon source;
    private int shoutPower;

    public ShoutEvent(Vogon source, int shoutPower) {
        this.source = source;
        this.shoutPower = shoutPower;
    }

    @Override
    public void execute(Human target) {
        if (target == null) {
            throw new NullPointerException("Target cannot be null");
        }

        if (target instanceof Prisoner prisoner) {
            prisoner.receiveShout(shoutPower);
        }
    }
}
