package com.controlfood.interfaces.http.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum StatusDto {
    ACTIVE,
    INACTIVE;

    @JsonCreator
    public static StatusDto from(String value) {
        for (StatusDto status : StatusDto.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        log.error("Received invalid status value. {}", value);
        return null;
    }
}
