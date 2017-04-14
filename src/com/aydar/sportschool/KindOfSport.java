package com.aydar.sportschool;

public class KindOfSport {
    private int mId;
    private String mName;

    public KindOfSport(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
