package com.example.hibernate_fundamental.entity;

import com.example.hibernate_fundamental.converter.GenderConverter;
import com.example.hibernate_fundamental.enums.Gender;
import com.example.hibernate_fundamental.types.GenderType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    //@Convert(converter = GenderConverter.class)
    @Type(GenderType.class)
    @Column(length = 6)
    private Gender gender;

    public Person() {
    }

    public Person(Long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
