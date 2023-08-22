package models;

import models.Item;

public class Store {
    Item[][] items;
 public Store () {
     this.items = new Item[7][3];
 }
 public Item getItem(int row, int column){
     return new Item(items[row][column]);
 }

 public Item serchItem(String itemName){
     for (int i = 0; i < items.length; i++) {
         for (int j = 0; j < items[i].length; j++) {
             if(items[i][j].getName().equals(itemName)){
                 return items[i][j];
             }
         }
     }
     System.out.println("there is no item named " + itemName + " in the store");
 return null;
 }
 public void setItem(int row,int column, Item item){
     items[row][column]=new Item(item);
 }
 public String toString(){
     String temp ="";
     for (int i = 0; i < items.length; i++) {
         switch (i) {
             case 0: temp += "\tDRINKS:        \n"; break;
             case 1: temp += "\tCEREAL:        \n"; break;
             case 2: temp += "\tDAIRY:         \n"; break;
             case 3: temp += "\tDELI:          \n"; break;
             case 4: temp += "\tGREENS:        \n"; break;
             case 5: temp += "\tCLOTHING:      \n"; break;
             case 6: temp += "\tELECTRONICS:   \n"; break;
         }
         for (int j = 0; j < items[i].length; j++) {
             temp += items[i][j].toString();
         }
            temp += "\n\n";
         }
     temp +="\t************************************************************************\n";
     return temp;
 }
 }
