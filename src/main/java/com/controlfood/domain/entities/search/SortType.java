package com.controlfood.domain.entities.search;

public enum SortType {
    ASC("asc"), DESC("desc");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
