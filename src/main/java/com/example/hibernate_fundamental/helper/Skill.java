package com.example.hibernate_fundamental.helper;

public class Skill {
    private String level;
    private int experience;

    public Skill() {
    }

    public Skill(String level, int experience) {
        this.level = level;
        this.experience = experience;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
