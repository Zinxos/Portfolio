package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    public Store (){
        movies = new ArrayList<Movie>();
    }
    public void addMovie(Movie movie){
        movies.add(new Movie(movie));
    }

    public Movie getMovie(String movieTitle){
        if(movies.isEmpty())
        {
            throw new IllegalStateException("you cannot search from list that is empty");
        }

        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().equals(movieTitle)){
                return movies.get(i);
            }
        }
        return null;
    }
    public void setMovie(Movie movie, int index){
        movies.add(index, new Movie(movie));
    }

    public void customerAction(String movieName, String action){
        if(movies.isEmpty())
        {
            throw new IllegalStateException("you cannot search from list that is empty");
        }
        if(movieName.isBlank()|| movieName == null)
        {
            throw new IllegalArgumentException("Movie title cannot be null or blank");
        }
        if(!action.equals("sell")&&!action.equals("rent")&&!action.equals("return"))
        {
            throw new IllegalArgumentException("Action choosed wrong you can only choose sell to buy movie, rent to rent it, or return to return it");
        }
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().equals(movieName)){
                switch (action){
                    case "sell" :
                        if(movies.get(i).isAvailable()==false)
                        {
                            throw new IllegalStateException("you cannot buy movie that we already rented by somebody before he return it");
                        }
                        System.out.println("You just bought " + movies.get(i).getName() +
                            " movie, you have to pay "+ movies.get(i).getSellPrice());
                        movies.remove(i);
                        System.out.println("movie " + movieName + " removed from library");
                        System.out.println("we wish good time at movie night");
                        break;
                    case "rent" : System.out.println("You just rent " + movies.get(i).getName() +
                            " movie, you have to pay 10$ and we will give you your change while you " +
                            "come to return movie cost of rent is "+ movies.get(i).getSellPrice() +
                            " per day");
                        movies.get(i).setAvailable(false);
                        break;
                    case "return" : System.out.println("thanks for returning " + movies.get(i).getName()
                            + " movie, ");
                        movies.get(i).setAvailable(true);
                        break;

                }

            } else if (i >= movies.size()) {
                System.out.println("theres no movie " + movieName);
            }
        }
    }
    @Override
    public String toString(){
        String temp = "";
        for(int i= 0;i < movies.size(); i++)
        {
            temp += movies.get(i).toString();
            temp += "\n\n";
        }

        return temp;
    }
    }
