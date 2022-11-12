package pl.piotrS.update;

import pl.piotrS.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookTableUpdate {
    public static void bookUpdate() {
        Scanner scanner = new Scanner(System.in);
        ResultSet genreNamesResult;
        ResultSet genreResult;

        try {
            Connection connection = DbConnect.Connect();
            Statement statement = connection.createStatement();
            System.out.println("Podaj autora książki której dane chcesz zmienić");
            String oldAuthor = scanner.nextLine();
            System.out.println("Podaj tytuł książki której dane chcesz zmienić");
            String titleToUpdate = scanner.nextLine();
            System.out.println("Podaj nowy tytuł książki");
            String newTitle = scanner.nextLine();
            System.out.println("Podaj nowego autora książki");
            String newAuthor = scanner.nextLine();
            System.out.println("podaj gatunerk książki (z powyżej wymienionych)");
           // moduł wyświetlenia wszystkich gatunków
            genreNamesResult = statement.executeQuery("select * from catalog_genre");
            while (genreNamesResult.next()) {
                System.out.println(genreNamesResult.getString("genre"));
            }
            //end
            String newGenre = scanner.nextLine();
            //moduł pozwalający wpisać gatunek a do bazy wrzucić kod gatunku
            genreResult = statement.executeQuery("select * from catalog_genre where Genre ='" + newGenre + "';");
            if (genreResult.next()) {
                String codeGenre = genreResult.getString("code_genre");
                //end
                String UpdateBookData = "Update Books set title = '" + newTitle + "', author = '" + newAuthor + "', code_Genre = '" +codeGenre + "' where Title = '" + titleToUpdate + "';";
                String afterBookUpdate = "Update catalog_author set author = '" + newAuthor + "' where author = '" + oldAuthor + "';";
                statement.executeUpdate(UpdateBookData);
                statement.executeUpdate(afterBookUpdate);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public static void authorUpdate() {

            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Podaj autora którego chcesz edytować");
                String oldAuthor = scanner.nextLine();
                System.out.println("Podaj nowego autora książki");
                String newAuthor = scanner.nextLine();
                Connection connection = DbConnect.Connect();
                Statement statement = connection.createStatement();
                String UpdateAuthorData = "Update catalog_author set author = '" + newAuthor + "' where author = '" + oldAuthor + "';";
                String afterAuthorUpdate = "Update books set author = '" + newAuthor + "' where author ='" + oldAuthor + "';";
                statement.executeUpdate(UpdateAuthorData);
                statement.executeUpdate(afterAuthorUpdate);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
