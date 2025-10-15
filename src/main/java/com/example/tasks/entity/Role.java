package com.example.tasks.entity;

public enum Role {
    USER(0),
    ADMIN(1);

    private int i;

    Role(int i) {
        this.i = i;

    }
    public int getValue() {
        return i;
    }
}
