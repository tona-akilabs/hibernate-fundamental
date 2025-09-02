package com.example.hibernate_fundamental.entity;

import com.example.hibernate_fundamental.helper.Skill;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "CLOB")
    //private Map<String, Skill> skills; // skill name -> details (level, experience, ...)
    private Map<String, Object> skills; // skill name -> details (level, experience, ...)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Object> skills) {
        this.skills = skills;
    }
}
