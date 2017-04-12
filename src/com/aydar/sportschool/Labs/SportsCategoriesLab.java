package com.aydar.sportschool.Labs;

import com.aydar.sportschool.Fetchers.PupilsFetcher;
import com.aydar.sportschool.Fetchers.SportsCategoriesFetcher;
import com.aydar.sportschool.Pupil;
import com.aydar.sportschool.SportsCategory;

import java.sql.SQLException;
import java.util.List;

public class SportsCategoriesLab {
    private static SportsCategoriesLab sSportsCategoriesLab;

    private List<SportsCategory> mSportsCategories;

    public static SportsCategoriesLab get() throws SQLException {
        if (sSportsCategoriesLab == null) {
            sSportsCategoriesLab = new SportsCategoriesLab();
        }
        return sSportsCategoriesLab;
    }
    private SportsCategoriesLab() throws SQLException {
        mSportsCategories = new SportsCategoriesFetcher().getSportsCategories();
    }

    public List<SportsCategory> getSportsCategories() {
        return mSportsCategories;
    }


}
