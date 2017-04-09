package db;

import com.intersys.jdbc.CacheDriver;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbConnection;

    private String url = "jdbc:Cache://localhost:1972/SPORT_SCHOOL/kk.log";
    private String username = "Admin";
    private String password = "blabla";

    private static Connection con;
    private Statement statement;

    private DBConnection() {
        try {
            Driver driver = new CacheDriver();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getDbConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Statement getStatement() {
        return statement;
    }
}
