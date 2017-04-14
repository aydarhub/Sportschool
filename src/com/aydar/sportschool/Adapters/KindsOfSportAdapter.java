package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.KindOfSport;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KindsOfSportAdapter {
    private static final String mQuery = "SELECT * FROM SPORTSCHOOL.KindOfSport";

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<KindOfSport> getKindsOfSport() throws SQLException {
        List<KindOfSport> kindOfSports = new ArrayList<>();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(mQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String name = mResultSet.getString("name");
            kindOfSports.add(new KindOfSport(id, name));
        }

        mStatement.close();

        return kindOfSports;
    }
}
