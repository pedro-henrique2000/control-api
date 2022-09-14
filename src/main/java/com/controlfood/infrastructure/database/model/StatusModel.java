package com.controlfood.infrastructure.database.model;


public enum StatusModel {
    INACTIVE,
    ACTIVE;

    public static StatusModel of(String value) {
        try {
            return StatusModel.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid status value " + value, e);
        }
    }

}
