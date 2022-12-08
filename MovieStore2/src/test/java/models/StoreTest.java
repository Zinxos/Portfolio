package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store;

    @BeforeEach
    public void setUp(){
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
        store.getMovie(0).setAvailable(false);
    }
    @Test
    public void addedMovie(){
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void serchMovies(){
        assertTrue(store.searchMovie("The Godfather").equals(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void movieSold(){
        store.sellMovie("The Godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }
    @Test
    public void rentedMovie(){
        store.rentMovie("The Godfather");
        assertFalse(store.searchMovie("The Godfather").isAvailable());
    }
    @Test
    public void returnedMovie(){
        store.searchMovie("The Shawshank Redemption").setAvailable(false);
        store.returnMovie("The Shawshank Redemption");
        assertTrue(store.searchMovie("The Shawshank Redemption").isAvailable());
    }

    @Test
    public void movieNotInStockSell(){
        store.rentMovie("The Shawshank Redemption");
        assertThrows(IllegalStateException.class,() -> store.sellMovie("The Shawshank Redemption"));

    }


}