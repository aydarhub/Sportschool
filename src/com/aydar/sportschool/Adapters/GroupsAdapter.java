package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.Group;
import com.aydar.sportschool.Trainer;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupsAdapter {

    private static final String mQuery = "SELECT * FROM SPORTSCHOOL.Party";

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        List<Trainer> trainers = new TrainersAdapter().getTrainers();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(mQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String name = mResultSet.getString("name");
            int trainerId = mResultSet.getInt("trainer");
            Trainer trainer = null;
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getId() == trainerId) {
                    trainer = trainers.get(i);
                    break;
                }
            }
            groups.add(new Group(id, name, trainer));
        }

        mDBConnection.close();

        return groups;
    }

    public void addGroup(String name, int trainerId) throws SQLException {
        final String insertQuery = "INSERT INTO SPORTSCHOOL.Party(name, trainer) " +
                "VALUES ('" + name + "', " + trainerId + ")";

        System.out.println(insertQuery);

        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();

        mStatement.executeUpdate(insertQuery);

        mDBConnection.close();
        mDBConnection = null;
    }
}
