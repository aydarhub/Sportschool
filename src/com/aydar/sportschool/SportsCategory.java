package com.aydar.sportschool;

public class SportsCategory {
    private int mId;
    private String mName;

    public SportsCategory(int id, String categoryName) {
        mId = id;
        mName = categoryName;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
