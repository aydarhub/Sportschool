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
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<SportsCategory> getSportsCategories() throws SQLException {
        List<SportsCategory> sportsCategories = new ArrayList<>();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(mQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String category = mResultSet.getString("category");
            sportsCategories.add(new SportsCategory(id, category));
        }

        mStatement.close();

        return sportsCategories;
    }
}
