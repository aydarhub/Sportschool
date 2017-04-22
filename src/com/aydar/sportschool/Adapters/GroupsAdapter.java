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

    public List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        List<Trainer> trainers = new TrainersAdapter().getTrainers();
        mDBConnection = new DBConnection();
        ResultSet resultSet = mDBConnection.getStatement().executeQuery(mQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            int trainerId = resultSet.getInt("trainer");
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
        mDBConnection.getStatement().executeUpdate(insertQuery);

        mDBConnection.close();
        mDBConnection = null;
    }

    public static void deleteItem(int id) throws SQLException {
        final String deleteQuery = "DELETE FROM SPORTSCHOOL.Party WHERE id = " + id;

        DBConnection dbConnection = new DBConnection();
        dbConnection.getStatement().executeUpdate(deleteQuery);
        dbConnection.close();
    }
}
