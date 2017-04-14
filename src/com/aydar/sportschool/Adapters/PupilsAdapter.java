package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.Group;
import com.aydar.sportschool.Pupil;
import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.db.DBConnection;
import com.sun.istack.internal.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PupilsAdapter {

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<Pupil> getPupils() throws SQLException {
        final String selectQuery = "SELECT * FROM SPORTSCHOOL.Pupil";
        List<Pupil> pupils = new ArrayList<>();
        List<SportsCategory> sportsCategories = new SportsCategoriesAdapter().getSportsCategories();
        List<Group> groups = new GroupsAdapter().getGroups();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(selectQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String name = mResultSet.getString("name");
            String birthday = mResultSet.getString("birthday");
            int groupId = mResultSet.getInt("groupId");
            Group group = null;
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getId() == groupId) {
                    group = new Group(id, groups.get(i).getName(), groups.get(i).getTrainer());
                    break;
                }
            }
            int sportsCategoryId = mResultSet.getInt("sportsCategory");
            SportsCategory sportsCategory = null;
            for (int i = 0; i < sportsCategories.size(); i++) {
                if (sportsCategories.get(i).getId() == sportsCategoryId) {
                    sportsCategory = sportsCategories.get(i);
                    break;
                }
            }
            String rewards = mResultSet.getString("rewards");
            String phone = mResultSet.getString("phone");
            String address = mResultSet.getString("address");
            pupils.add(new Pupil(id, name, birthday, group, sportsCategory, rewards, phone, address));
        }

        mDBConnection.close();
        mDBConnection = null;

        return pupils;
    }

    public void addPupil(String name, String birthday, int groupId, @Nullable String phone, @Nullable String address, @Nullable int sportsCategoryId, @Nullable String rewards) throws SQLException {
        StringBuilder insertQueryColumns = new StringBuilder();
        StringBuilder insertQueryValues = new StringBuilder();

        insertQueryColumns.append("INSERT INTO SPORTSCHOOL.Pupil(name, birthday, groupId");
        insertQueryValues.append("VALUES('").append(name).append("', '").append(birthday).append("', ").append(groupId);

        if (phone != null && !phone.equals("")) {
            insertQueryColumns.append(", phone");
            insertQueryValues.append(", '").append(phone).append("'");
        }
        if (address != null && !address.equals("")) {
            insertQueryColumns.append(", address");
            insertQueryValues.append(", '").append(address).append("'");
        }
        if (sportsCategoryId >= 0) {
            insertQueryColumns.append(", sportsCategory");
            insertQueryValues.append(", ").append(sportsCategoryId);
        }
        if (rewards != null && !rewards.equals("")) {
            insertQueryColumns.append(", rewards");
            insertQueryValues.append(", '").append(rewards).append("'");
        }
        insertQueryColumns.append(") ");
        insertQueryValues.append(")");


        System.out.println(insertQueryColumns.toString() + insertQueryValues.toString());
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mStatement.executeUpdate(insertQueryColumns.toString() + insertQueryValues.toString());
        mDBConnection.close();
        mDBConnection = null;

    }
}
