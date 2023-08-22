import models.Movie;
import models.Store;

import java.util.stream.IntStream;

public class Main {
    static Store movies = new Store();

    public static void main(String[] args) {
        movies.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        movies.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));


    }

    }


