package pl.piotrS.Check;

import pl.piotrS.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckBooks {
    public static ResultSet checkBooks() {


        ResultSet result = null;
        try {
            Connection connection = DbConnect.Connect();
            Statement statement = connection.createStatement();

            result = statement.executeQuery("select * from Books");
            while (result.next()) {
                System.out.println(result.getString("title") + " - " + result.getString("author"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
