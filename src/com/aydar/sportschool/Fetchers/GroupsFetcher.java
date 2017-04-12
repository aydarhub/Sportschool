package com.aydar.sportschool.Fetchers;

import com.aydar.sportschool.Group;
import com.aydar.sportschool.Labs.SportsCategoriesLab;
import com.aydar.sportschool.Pupil;
import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupsFetcher {

    private static final String mQuery = "SELECT * FROM SPORTSCHOOL.Party";

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(mQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String name = mResultSet.getString("name");
            String trainer = mResultSet.getString("trainer");
            groups.add(new Group(id, name, trainer));
        }

        mDBConnection.close();

        return groups;
    }
}
