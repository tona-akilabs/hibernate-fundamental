package com.example.hibernate_fundamental.converter;

import com.example.hibernate_fundamental.enums.Gender;
import jakarta.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, Character> {

    public Character convertToDatabaseColumn(Gender value) {
        if (value == null) {
            return null;
        }

        return value.getCode();
    }

    public Gender convertToEntityAttribute(Character value) {
        if (value == null) {
            return null;
        }

        return Gender.fromCode(value);
    }
}
