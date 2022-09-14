package com.controlfood.infrastructure.database.repositories.jpa.converter;

import com.controlfood.infrastructure.database.model.StatusModel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusModel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusModel status) {
        return status.getCode();
    }

    @Override
    public StatusModel convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(StatusModel.values())
                .filter(s -> s.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
