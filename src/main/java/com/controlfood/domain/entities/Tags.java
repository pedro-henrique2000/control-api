package com.controlfood.domain.entities;

public enum Tags {
    ELETRONICAL,
    VIDEOGAME,
    TOOLS,
    COMPUTER;

    public static Tags of(String value) {
        try {
            return Tags.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid tag value " + value, e);
        }
    }
}
