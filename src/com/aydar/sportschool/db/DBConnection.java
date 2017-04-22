package com.aydar.sportschool.db;

import com.intersys.jdbc.CacheDriver;

import java.sql.*;

public class DBConnection {

    private String url = "jdbc:Cache://localhost:1972/SPORT_SCHOOL/kk.log";
    private String username = "Admin";
    private String password = "blabla";

    private static Connection mConnection;
    private Statement mStatement;

    public DBConnection() {
        try {
            Driver driver = new CacheDriver();
            DriverManager.registerDriver(driver);
            mConnection = DriverManager.getConnection(url, username, password);
            mStatement = mConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return mStatement;
    }

    public void close() {
        try {
            mStatement.close();
            mConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
