import models.Cart;
import models.Item;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
        System.out.println(cart.checkOut());
    }
}
