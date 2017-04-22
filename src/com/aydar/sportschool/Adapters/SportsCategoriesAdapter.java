package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SportsCategoriesAdapter {


    private DBConnection mDBConnection;

    public List<SportsCategory> getSportsCategories() throws SQLException {
        final String mQuery = "SELECT * FROM SPORTSCHOOL.SportsCategory";

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

    public void addSportsCategory(String name) throws SQLException {
        final String insertQuery = "INSERT INTO SPORTSCHOOL.SportsCategory(category) " +
                "VALUES ('" + name +  "')";

        System.out.println(insertQuery);

        mDBConnection = new DBConnection();

        mDBConnection.getStatement().executeUpdate(insertQuery);

        mDBConnection.close();
        mDBConnection = null;
    }

    public static void deleteItem(int id) throws SQLException {
        final String deleteQuery = "DELETE FROM SPORTSCHOOL.SportsCategory WHERE id = " + id;

        DBConnection dbConnection = new DBConnection();
        dbConnection.getStatement().executeUpdate(deleteQuery);
        dbConnection.close();
    }
}
