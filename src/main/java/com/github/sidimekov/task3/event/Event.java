package com.github.sidimekov.task3.event;

import com.github.sidimekov.task3.entity.Human;

public interface Event {
    void execute(Human target);
}
