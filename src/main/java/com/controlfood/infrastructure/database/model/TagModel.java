package com.controlfood.infrastructure.database.model;

public enum TagModel {

    ELETRONICAL,
    VIDEOGAME,
    TOOLS,
    COMPUTER;

    public static TagModel of(String value) {
        try {
            return TagModel.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid tag value " + value, e);
        }
    }

}
