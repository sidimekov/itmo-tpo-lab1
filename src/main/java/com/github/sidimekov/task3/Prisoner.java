package com.github.sidimekov.task3;

public class Prisoner extends Human {
    private boolean shoutedAt = false;

    public Prisoner(String name, String mood) {
        super(mood);
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public boolean isShoutedAt() {
        return shoutedAt;
    }

    public void setShoutedAt(boolean shoutedAt) {
        this.shoutedAt = shoutedAt;
    }
}
