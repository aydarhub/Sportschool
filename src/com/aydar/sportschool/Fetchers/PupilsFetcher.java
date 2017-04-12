package com.aydar.sportschool.Fetchers;

import com.aydar.sportschool.Group;
import com.aydar.sportschool.Labs.GroupsLab;
import com.aydar.sportschool.Labs.SportsCategoriesLab;
import com.aydar.sportschool.Pupil;
import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PupilsFetcher {

    private static final String mQuery = "SELECT * FROM SPORTSCHOOL.Pupil";

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<Pupil> getPupils() throws SQLException {
        List<Pupil> pupils = new ArrayList<>();
        List<SportsCategory> sportsCategories = SportsCategoriesLab.get().getSportsCategories();
        List<Group> groups = GroupsLab.get().getGroups();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(mQuery);

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
                    sportsCategory = new SportsCategory(id, sportsCategories.get(i).getCategoryName());
                    break;
                }
            }
            String rewards = mResultSet.getString("rewards");
            String phone = mResultSet.getString("phone");
            String address = mResultSet.getString("address");
            pupils.add(new Pupil(id, name, birthday, group, sportsCategory, rewards, phone, address));
        }

        mDBConnection.close();

        return pupils;
    }
}
