import models.Cart;
import models.Item;
import models.Store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Cart shoppingCart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {



        try {

            loadProducts("products.txt");
            System.out.println(store);
            manageProducts();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Process Complete");
        }
    }

    public static void loadProducts(String fileName) throws FileNotFoundException {
        FileInputStream myFile = new FileInputStream(fileName);
        Scanner scanner = new Scanner(myFile);
        for (int i = 0; scanner.hasNextLine(); i++) {
            String tempLine = scanner.nextLine();
            String[] tempItemsTable = tempLine.split(";");
            for (int j = 0; j < tempItemsTable.length; j++) {
                String[] justToDrop = tempItemsTable[j].split("=");
                store.setItem(i, j, new Item(justToDrop[0], Double.parseDouble(justToDrop[1])));
            }

        }
        scanner.close();
    }

    public static void manageProducts(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while(shouldContinue){
            System.out.println("what would you like to do? \n 1 - add product to your cart \n 2 - show the cart \n 3 - remove product from your cart \n 4 - show items in store \n 5 - do checkout");
            String anwser = scanner.nextLine();

            switch (anwser){
                case "1":
                    boolean shouldContinueSmall = true;
                    while(shouldContinueSmall){
                        System.out.println("what product would you like to add, insert item name to add item or 'exit' to perform other action");
                        String itemOrExit = scanner.nextLine();
                        if(itemOrExit.equals("exit")) {
                            shouldContinueSmall = false;
                        }else {
                            if(store.serchItem(itemOrExit) != null){
                                shoppingCart.addItem(store.serchItem(itemOrExit));
                            }
                        }

                    }

                    break;
                case "2":
                    System.out.println("There is in your cart: \n" + shoppingCart);
                    break;
                case "3":
                    System.out.println("insert name of product you would like to remove");
                    String itemName = scanner.nextLine();
                    if(shoppingCart.contains(store.serchItem(itemName))){
                        shoppingCart.removeItem(itemName);
                        System.out.println("product " + itemName + " has been removed from the cart" );
                    }else {
                        System.out.println("there's no " + itemName + " in your cart");
                    }
                    break;
                case "4":
                    System.out.println(store);
                    break;
                case "5":
                    System.out.println(shoppingCart.checkOut());
                    shouldContinue = false;
                    break;

            }
        }

    }
}
