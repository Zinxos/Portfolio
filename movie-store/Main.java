import models.Movie;
import models.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        store.addMovie(new Movie("Shrek","DVD",9));
        store.addMovie(new Movie("Shrek2","BlueRay",7));
        store.addMovie(new Movie("Shrek3","DVD",8));
        store.addMovie(new Movie("Shrek4","BlueRay",2));
        System.out.println(store);
        try {

            loadMovies("movies.txt");
            System.out.println("new movies loaded");
            System.out.println(store);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        manageMovies();





    }
    public static void loadMovies(String fileName) throws FileNotFoundException {
        File myFile = new File(fileName);
        Scanner scanner = new Scanner(myFile);
        String[] moviesFromFile = new String[3];
        while(scanner.hasNextLine()){
            moviesFromFile = scanner.nextLine().split("--");
            store.addMovie(new Movie(moviesFromFile[0],moviesFromFile[1],Integer.parseInt(moviesFromFile[2])));
        }
    }


    public static void manageMovies(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        String titleAnwser;
        String action;
        int anwser;
        while (shouldContinue){
            System.out.println("list of actions: \n 1) Buy a movie \n 2) Rent a movie \n 3) Return a movie \n 4) Show movie list \n 5) Quit");
            System.out.println("please choose the action inputing 1, 2 ,3 ,4, 5");
            anwser = Integer.parseInt(scanner.nextLine());
            System.out.println("what is the name of movie you'd like to buy?");
            titleAnwser = scanner.nextLine();
            if(titleAnwser.isBlank()||titleAnwser == null) {
                System.out.println("wrong title it cannot be blank or null");
                continue;
            }
            if((anwser==1||anwser==2)&&store.getMovie(titleAnwser).isAvailable() == false){
                System.out.println(titleAnwser + " movie is unavailable at the moment, we're sorry");
                continue;
            }
            switch (anwser){
                case 1:
                    action = "sell";
                    store.customerAction(titleAnwser,action);
                    break;
                case 2:
                    action = "rent";
                    store.customerAction(titleAnwser,action);
                    break;
                case 3:
                    action = "return";
                    store.customerAction(titleAnwser,action);
                    break;
                case 4:
                    System.out.println(store);
                    break;
                case 5:
                    shouldContinue = false;
                    break;

            }
        }
    }
    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */

}
