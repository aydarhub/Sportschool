package com.aydar.sportschool;

public class SportsCategory {
    private int mId;
    private String mCategoryName;

    public SportsCategory(int id, String categoryName) {
        mId = id;
        mCategoryName = categoryName;
    }

    public int getId() {
        return mId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }
}
