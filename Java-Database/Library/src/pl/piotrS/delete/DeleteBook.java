package pl.piotrS.delete;

import pl.piotrS.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBook {
    public static void deleteBook() {
        ResultSet result = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj autora książki którą chcesz usunąć z bazy");
        String deleteBookAuthor = scanner.nextLine();
        System.out.println("podaj tytuł książki który chcesz usunąć z bazy");
    String deleteBookTitle = scanner.nextLine();

        try {
            Connection connection = DbConnect.Connect();
            Statement statement = connection.createStatement();
            String deleteBookSql = "delete from Books where title ='"+ deleteBookTitle +"';";
            Statement checkStatement = connection.createStatement();
            String noBooks = "delete from catalog_author where author ='"+ deleteBookAuthor +"';";
            statement.executeUpdate(deleteBookSql);
            result = checkStatement.executeQuery("select * from books where author ='"+ deleteBookAuthor +"';");
            if(result.next()) {

            }else{
                statement.executeUpdate(noBooks);
            System.out.println("brak książek autora - autor usunięty z bazy");}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
