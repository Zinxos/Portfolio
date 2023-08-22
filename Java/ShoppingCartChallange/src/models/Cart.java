package models;

import models.Item;

import java.util.ArrayList;

public class Cart {
    ArrayList <Item> items;
    public Cart (){
        items = new ArrayList<Item>();
    }

    public Item getItem(String itemName) {
        if(items.isEmpty())
        {
            throw new IllegalStateException("you cannot search from list that is empty");
        }
        if(items.contains(itemName))
        {
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getName().equals(itemName)){
                    return items.get(i);
                }
            }
        }
        return null;

    }

    public void setItems(Item item, int index) {
        items.add(index, new Item(item));
    }

    public void addItem(Item item){
        if(!items.contains(item)){
            items.add(new Item(item));
            System.out.println("product added to cart");
        }else{
            System.out.println("product is already in your cart");
        }
    }

    public String checkOut(){
        if(items.isEmpty())
        {
            throw new IllegalStateException("you cannot do check out from list that is empty");
        }
        int sum = 0 ;
        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).getPrice();
        }
    return
            "RECEIPT\n\n" +
            items.toString() + "\n\n" +
            "Subtotal: $" + sum + "\n" +
            "Tax: $" + sum*0.13 + "\n" +
            "Total: $" + sum*1.13 + "\n";
    }






    public void setItem(Item item, int index) {
        items.add(index,new Item(item));
    }

    public void removeItem(String itemName){
        if(items.isEmpty())
        {
            throw new IllegalStateException("you cannot remove from list that is empty");
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(itemName)){
            items.remove(i);
            }
        }
    }
    @Override
    public String toString(){
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString() + "\n";
        }
        return temp;
    }
    public boolean contains(Item item){
        if(items.contains(item)){
            return true;
        }else {
            return false;
        }
    }
}
