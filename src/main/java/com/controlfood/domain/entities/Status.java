package com.controlfood.domain.entities;

public enum Status {
    ACTIVE,
    INACTIVE;

    public static Status of(String value) {
        try {
            return Status.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid status value " + value, e);
        }
    }

}
