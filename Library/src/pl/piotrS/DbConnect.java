package pl.piotrS;

import java.sql.*;

public class DbConnect {

    public static Connection Connect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
