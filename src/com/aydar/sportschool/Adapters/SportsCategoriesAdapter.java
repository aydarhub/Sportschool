package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SportsCategoriesAdapter {

    private static final String mQuery = "SELECT * FROM SPORTSCHOOL.SportsCategory";

    private DBConnection mDBConnection;

    public List<SportsCategory> getSportsCategories() throws SQLException {
        List<SportsCategory> sportsCategories = new ArrayList<>();
        mDBConnection = new DBConnection();
        ResultSet resultSet = mDBConnection.getStatement().executeQuery(mQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String category = resultSet.getString("category");
            sportsCategories.add(new SportsCategory(id, category));
        }

        mDBConnection.close();
        mDBConnection = null;

        return sportsCategories;
    }
}
