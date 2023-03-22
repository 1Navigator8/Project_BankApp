package com.example.bankapp.entity.enums;

public enum AccountStatus {
    ACTIVE(0),
    PENDING(1),
    BLOCKED(2),
    REMOVED(3);
    private final int value;

    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}