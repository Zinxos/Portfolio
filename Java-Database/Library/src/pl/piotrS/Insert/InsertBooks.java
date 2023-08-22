package pl.piotrS.Insert;

import pl.piotrS.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertBooks {
    public static ResultSet insertBooks() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ResultSet result = null;
        ResultSet idResult = null;
        ResultSet elseResult = null;
        ResultSet genreResult = null;
        ResultSet genreNamesResult = null;
        int autId;
        String codeGenre;
        try {
            Connection connection = DbConnect.Connect();
            Statement statement = connection.createStatement();
            System.out.println("Podaj autora którego książke chcesz dodać");
            String scanAuthor = scanner.nextLine();
            System.out.println("Podaj tytuł książki którą chcesz dodać");
            String scanTitle = scanner.nextLine();
            System.out.println("Podaj gatunek książki którą chcesz dodać (musi zawierać sie w poniżej wypisanych)");
            // moduł wyświetlenia wszystkich gatunków
            genreNamesResult = statement.executeQuery("select * from catalog_genre");
            while (genreNamesResult.next())
            {
                System.out.println(genreNamesResult.getString("genre"));
            }
            // end
            String scanGenre = scanner.nextLine();
            idResult = statement.executeQuery("select * from books where author ='" + scanAuthor + "';");
            if(idResult.next()) {
                autId = idResult.getInt("aut_id");
                genreResult = statement.executeQuery("select * from catalog_genre where Genre ='"+scanGenre+"';");
                if(genreResult.next()){
                    codeGenre = genreResult.getString("code_genre");
                    statement.executeUpdate("insert into Books(author ,title ,aut_id, code_genre)" +
                        "Values('"+scanAuthor+"' , '"+scanTitle+"' ,'"+autId+"','"+codeGenre+"');");}
            }else {

                statement.executeUpdate("insert into catalog_author(author) values ('" + scanAuthor + "');");
                    elseResult = statement.executeQuery("select * from catalog_author where author ='" + scanAuthor + "';");
                if (elseResult.next()) {
                    autId = elseResult.getInt("aut_id");
                    genreResult = statement.executeQuery("select * from catalog_genre where Genre ='"+scanGenre+"';");
                    if(genreResult.next()) {
                        codeGenre = genreResult.getString("code_genre");
                        statement.executeUpdate("insert into Books(author ,title ,aut_id,code_genre)" +
                                "Values('" + scanAuthor + "' , '" + scanTitle + "' ,'" + autId + "','" + codeGenre + "');");
                    }
                }else {
                    System.out.println("zepsuło się coś");
                }
            }

            result = statement.executeQuery("select * from books");
            while (result.next()) {
                System.out.println(result.getString("title") + " - " + result.getString("author"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
