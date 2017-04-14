package com.aydar.sportschool;

public class Group {
    private int mId;
    private String mName;
    private Trainer mTrainer;

    public Group(int id, String name, Trainer trainer) {
        mId = id;
        mName = name;
        mTrainer = trainer;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Trainer getTrainer() {
        return mTrainer;
    }
}
