package com.aydar.sportschool.db;

import com.intersys.jdbc.CacheDriver;

import java.sql.*;

public class DBConnection {

    private String url = "jdbc:Cache://localhost:1972/SPORT_SCHOOL/kk.log";
    private String username = "Admin";
    private String password = "blabla";

    private static Connection con;
    private Statement statement;

    public DBConnection() {
        try {
            Driver driver = new CacheDriver();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void close() {
        try {
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
