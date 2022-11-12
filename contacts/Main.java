import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static ContactManager contactBook = new ContactManager();

    public static void main(String[] args) {


       /* Contact newContact;
        try {
            contactBook.addContact(new Contact("Adam", "980283932", "05/11/1999"));
            contactBook.addContact(new Contact("Ryan", "6135012424", "11/11/1992"));
            contactBook.addContact(new Contact("Gio", "6477092344", "11/11/1993"));
            contactBook.addContact(new Contact("Thomas" ,"8192256979" ,"11/11/1994"));

        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("\nProcess Complete.");
        }
*/
        try{
            loadContacts("contacts.txt");
            System.out.println("contacts loaded");
            System.out.println(contactBook);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            System.out.println("\nProcess Complete.");
        }
        manageContacts();

    }
    public static void manageContacts() {
        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        while(shouldContinue){
            System.out.println("1. add contact \n 2.remove contact \n 3.exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("what is new contact name?");
                    String newContactName = scanner.next();
                    System.out.println("what is new contact phone number?");
                    String newContactPhoneNumber = scanner.next();
                    System.out.println("what is new contact birth date?");
                    String newContactBirthDate = scanner.next();
                    if (newContactName == null || newContactName.isBlank()) {
                        throw new IllegalArgumentException("name cannot be null or blank");
                    }
                    if (newContactPhoneNumber == null || newContactPhoneNumber.isBlank()) {
                        throw new IllegalArgumentException("phone number cannot be null or blank");
                    }
                    if (newContactPhoneNumber.length() < 5) {
                        throw new IllegalArgumentException("phone number cannot be less than 5 character");
                    }
                    try {
                        contactBook.addContact(new Contact(newContactName, newContactPhoneNumber, newContactBirthDate));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + contactBook);
                    }
                    break;
                case 2:
                    System.out.println("what is name of contact you would like to remove");
                    String contactToRemove = scanner.next();
                    contactBook.removeContact(contactToRemove);
                    System.out.println("\n\nUPDATED CONTACTS\n\n" + contactBook);
                    break;

                case 3:
                    shouldContinue = false;
                    break;
            }

            }
        }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        File myFile = new File(fileName);
        Scanner scanner = new Scanner(myFile);

        try{
            while(scanner.hasNextLine()){
                contactBook.addContact(new Contact(scanner.next(),scanner.next(),scanner.next()));
        }
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
