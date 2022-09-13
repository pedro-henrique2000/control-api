package com.controlfood.interfaces.http.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum TagsDto {

    ELETRONICAL,
    VIDEOGAME,
    TOOLS,
    COMPUTER;

    @JsonCreator
    public static TagsDto from(String value) {
        for (TagsDto tags : TagsDto.values()) {
            if (tags.name().equals(value)) {
                return tags;
            }
        }
        log.error("Received invalid Tag value. {}", value);
        return null;
    }

}
