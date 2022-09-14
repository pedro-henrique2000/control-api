package com.controlfood.infrastructure.database.model;


public enum StatusModel {
    INACTIVE(0),
    ACTIVE(1);

    int code;

    StatusModel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusModel of(String value) {
        try {
            return StatusModel.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid status value " + value, e);
        }
    }

}
