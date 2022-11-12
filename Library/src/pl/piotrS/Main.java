package pl.piotrS;

import pl.piotrS.Check.CheckAuthor;
import pl.piotrS.Check.CheckBooks;
import pl.piotrS.Insert.InsertBooks;
import pl.piotrS.delete.DeleteBook;
import pl.piotrS.update.BookTableUpdate;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {


        boolean start = true;
        int menuOption;
        Scanner scanner = new Scanner(System.in);
        while (start)
        {
            System.out.println("1. Sprawdź książki w bazie");
            System.out.println("2. Sprawdź autorów w bazie");
            System.out.println("3. Dodaj książke do bazy");
            System.out.println("4. Dodaj autora do bazy");
            System.out.println("5. Zmień dane książki");
            System.out.println("6. Zmień dane Autora");
            System.out.println("7. Usuń książke z bazy");
            System.out.println("8. Dodaj dane z pliku XML");
            System.out.println("9. zakończ działanie aplikacji");


            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1 -> CheckBooks.checkBooks();
                case 2 -> CheckAuthor.checkAuthor();
                case 3 -> InsertBooks.insertBooks();
                case 4 -> System.out.println("opcja w trakcie tworzenia");
                case 5 -> BookTableUpdate.bookUpdate();
                case 6 -> BookTableUpdate.authorUpdate();
                case 7 -> DeleteBook.deleteBook();
                case 8 -> xmlReader.xmlReader();
                case 9 -> start = false;
            }



//todo opcja wyświetlania książek danego wybranego autora
            // TODO: 19.01.2022 poogarniać indexy i klasy wspólne dla zgodności z zasadami solid
            // TODO: 20.01.2022 fajnie to działa wszystko tak naprawdę już na miejscu ew zrobić przerzucanie danych z bazy do xml ale nwm czy mi się chce
            // TODO: 20.01.2022 podzielić funkcje na częsci aby usunąć z nich funkcjonalności z których korzysta więcej niż jedna funkcja i
            //  stworzyć oddzielne funkcje (solid+++)
        }
   }
}

