package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.KindOfSport;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KindsOfSportAdapter {

    private DBConnection mDBConnection;

    public List<KindOfSport> getKindsOfSport() throws SQLException {
        final String selectQuery = "SELECT * FROM SPORTSCHOOL.KindOfSport";
        List<KindOfSport> kindOfSports = new ArrayList<>();
        mDBConnection = new DBConnection();
        ResultSet resultSet = mDBConnection.getStatement().executeQuery(selectQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            kindOfSports.add(new KindOfSport(id, name));
        }

        mDBConnection.close();
        mDBConnection = null;

        return kindOfSports;
    }

    public void addKindOfSport(String name) throws SQLException {
        final String insertQuery = "INSERT INTO SPORTSCHOOL.KindOfSport(name) " +
                "VALUES ('" + name +  "')";

        System.out.println(insertQuery);

        mDBConnection = new DBConnection();

        mDBConnection.getStatement().executeUpdate(insertQuery);

        mDBConnection.close();
        mDBConnection = null;
    }

    public static void deleteItem(int id) throws SQLException {
        final String deleteQuery = "DELETE FROM SPORTSCHOOL.KindOfSport WHERE id = " + id;

        DBConnection dbConnection = new DBConnection();
        dbConnection.getStatement().executeUpdate(deleteQuery);
        dbConnection.close();
    }
}
