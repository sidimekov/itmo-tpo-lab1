package com.github.sidimekov.task3.shoutEvent;

import com.github.sidimekov.task3.entity.Human;

public interface Event {
    void execute(Human target);
}