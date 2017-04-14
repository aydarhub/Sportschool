package com.aydar.sportschool.Adapters;

import com.aydar.sportschool.KindOfSport;
import com.aydar.sportschool.SportsCategory;
import com.aydar.sportschool.Trainer;
import com.aydar.sportschool.db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrainersAdapter {

    private DBConnection mDBConnection;
    private Statement mStatement;
    private ResultSet mResultSet;

    public List<Trainer> getTrainers() throws SQLException {
        final String selectQuery = "SELECT * FROM SPORTSCHOOL.Trainer";
        List<Trainer> trainers = new ArrayList<>();
        List<SportsCategory> sportsCategories = new SportsCategoriesAdapter().getSportsCategories();
        List<KindOfSport> kindsOfSport = new KindsOfSportAdapter().getKindsOfSport();
        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();
        mResultSet = mStatement.executeQuery(selectQuery);

        while (mResultSet.next()) {
            int id = mResultSet.getInt("ID");
            String name = mResultSet.getString("name");
            String birthday = mResultSet.getString("birthday");
            int sportsCategoryId = mResultSet.getInt("sportsCategory");
            SportsCategory sportsCategory = null;
            for (int i = 0; i < sportsCategories.size(); i++) {
                if (sportsCategories.get(i).getId() == sportsCategoryId) {
                    sportsCategory = new SportsCategory(id, sportsCategories.get(i).getName());
                    break;
                }
            }
            int kindOfSportId = mResultSet.getInt("kindOfSport");
            KindOfSport kindOfSport = null;
            for (int i = 0; i < sportsCategories.size(); i++) {
                if (kindsOfSport.get(i).getId() == kindOfSportId) {
                    kindOfSport = new KindOfSport(id, kindsOfSport.get(i).getName());
                    break;
                }
            }
            String phone = mResultSet.getString("phone");
            String address = mResultSet.getString("address");
            trainers.add(new Trainer(id, name, birthday, kindOfSport, sportsCategory, phone, address));
        }

        mDBConnection.close();
        mDBConnection = null;

        return trainers;
    }

    public void addTrainer(String name, String birthday, int kindOfSportId, int sportsCategoryId, String phone, String address) throws SQLException {

        final String insertQuery = "INSERT INTO SPORTSCHOOL.Trainer(name, birthday, kindOfSport, sportsCategory, phone, address) " +
                "VALUES ('" + name + "', '" + birthday + "', " + kindOfSportId + ", " +  sportsCategoryId + ", '" + phone + "', '" + address + "')";

        System.out.println(insertQuery);

        mDBConnection = new DBConnection();
        mStatement = mDBConnection.getStatement();

        mStatement.executeUpdate(insertQuery);

        mDBConnection.close();
        mDBConnection = null;

    }
}
