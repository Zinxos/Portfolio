package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }
    public Item searchItem(String name) {
        Predicate<Item> searchedItem = item -> item.getName().equals(name);

        return items
                .stream()
                .filter(searchedItem)
                .findFirst()
                .orElse(null);
    }


    public boolean contains(Item someItem){
        Predicate<Item> isThereItem = item -> item.equals(someItem);
        return items.stream()
                .anyMatch(isThereItem);
    }

    public boolean add(Item item){
        if(items.contains(item)){
            return false;
        }
        items.add(item);
        return true;
    }
    public boolean remove(String itemName){
        if(items.isEmpty())
        {
            throw new IllegalStateException("you can't remove item from empty cart");
        }
        if(items.contains(searchItem(itemName))){
            items.removeIf((item) -> item.getName().equals(itemName));
            System.out.println("product removed from the cart");
            return true;
        }else {
            System.out.println("there is no item as "+ itemName + " in the cart");
            return false;
        }
    }
    public double getSubtotal(){
       return items.stream()
               .mapToDouble((item) -> item.getPrice())
               .sum();
    }
    public double getTax(double subtotal){
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(subtotal*0.13));
    }
    public double getTotal(double subtotal, double tax){
        return subtotal+tax;
    }
    public void clear(){
        items.clear();
    }

    public String checkOut(){
        if(items.isEmpty())
        {
            throw new IllegalStateException("you can't remove item from empty cart");
        }
        return
                "RECEIPT\n\n" +
                        items.toString() + "\n\n" +
                        "Subtotal: $" + getSubtotal() + "\n" +
                        "Tax: $" + getTax(getSubtotal()) + "\n" +
                        "Total: $" + getTotal(getSubtotal(),getTax(getSubtotal())) + "\n";
    }






    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}