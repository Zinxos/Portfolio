package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
Cart cart = new Cart();
    @BeforeEach
    public void beforeStart(){
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itIsAdded(){
        assertTrue(new Item("Pepsi", 1.99).equals(cart.getItem(0)));
    }

    @Test
    public void containsIt(){
        if(!(cart.contains(new Item("epsi", 1.99)))){
            assertTrue(cart.contains(new Item("Pepsi", 1.99)));
        }
    }
    @Test
    public void noDuplicate(){
        assertFalse(cart.add(new Item("Pepsi", 1.99)));
    }
    @Test
    public void isItRemoved(){
        if(!(cart.remove("pepsi"))){
            if(cart.remove("Pepsi")){
                assertFalse(cart.contains(new Item("Pepsi", 1.99)));
            }
        }

    }
    @Test
    public void isSubtotalCorrect(){
        assertEquals(3.98, cart.getSubtotal() );
    }
    @Test
    public void isTaxValid(){
        assertEquals(0.52,cart.getTax(cart.getSubtotal()));
    }
    @Test
    public void isTotalValid(){
        assertEquals(4.50, cart.getTotal(cart.getSubtotal(),cart.getTax(cart.getSubtotal())));
    }

    @Test
    public void removeExeption(){
        cart.clear();
        assertThrows(IllegalStateException.class,() -> cart.remove("Pepsi"));
    }

    @Test
    public void checkOutExeption(){
        cart.clear();
        assertThrows(IllegalStateException.class,() -> cart.checkOut());
    }

}