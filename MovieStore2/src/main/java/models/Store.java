package models;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Store {
    public ArrayList<models.Movie> movies;

    public Store() {
        this.movies = new ArrayList<models.Movie>();
    }

    public models.Movie getMovie(int index) {
        return new models.Movie(this.movies.get(index));
    }

    public void setMovie(int index, models.Movie movie) {
        this.movies.set(index, new models.Movie(movie));
    }
    public boolean contains(Movie movie){
        return this.movies.contains(movie);
    }
    public void addMovie(Movie movie){
        movies.add(new Movie(movie));
    }

    public void sellMovie(String movieTitle){
        if(!(searchMovie(movieTitle).isAvailable())){
            throw new IllegalStateException("you cannot buy a movie that is already rented");
        }
        movies.removeIf((movie) -> movie.getName().equals(movieTitle));
    }

   /* public void sellMovie(String movieTitle){
        if(!(searchMovie(movieTitle).isAvailable())){
            throw new IllegalStateException("you cannot buy a movie that is already rented");
        }
        movies.remove(searchMovie(movieTitle));
    }

    */
    public Movie searchMovie(String name) {
        Predicate<Movie> searchedMovie = movie -> movie.getName().equals(name);

        return movies
                .stream()
                .filter(searchedMovie)
                .findFirst()
                .orElse(null);
    }
    public void returnMovie(String name){
        if(searchMovie(name).isAvailable()){
            throw new IllegalStateException("you cannot return a movie that is not rented");
        }
        searchMovie(name).setAvailable(true);
    }
    public void rentMovie(String name){
        if(!(searchMovie(name).isAvailable())){
            throw new IllegalStateException("you cannot rent a movie that is already rented");
        }
        searchMovie(name).setAvailable(false);
    }



        public String toString() {
            String temp = "";
            for (int i = 0; i < this.movies.size(); i++) {
                temp += this.movies.get(i).toString();
                temp += "\n\n";
            }
            return temp;
        }

    }
