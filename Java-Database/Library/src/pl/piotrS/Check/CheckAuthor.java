package pl.piotrS.Check;

import pl.piotrS.DbConnect;

import java.sql.*;

public class CheckAuthor {

    public static ResultSet checkAuthor() {

        ResultSet result = null;
        try {
            Connection connection = DbConnect.Connect();
            Statement statement = connection.createStatement();
            result = statement.executeQuery("select * from catalog_author");
            while(result.next()){
                System.out.println(result.getString("author"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
