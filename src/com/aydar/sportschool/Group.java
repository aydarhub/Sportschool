package com.aydar.sportschool;

public class Group {
    private int id;
    private String name;
    private String trainer;

    public Group(int id, String name, String trainer) {
        this.id = id;
        this.name = name;
        this.trainer = trainer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTrainer() {
        return trainer;
    }
}
