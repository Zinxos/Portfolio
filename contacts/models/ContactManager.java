package models;

import java.util.ArrayList;
import java.util.Date;

public class ContactManager {

    ArrayList<Contact> contacts ;

    public ContactManager (){
       contacts = new ArrayList<Contact>();
    }
    public Contact getContact(int index){
        return contacts.get(index);
    }
    public void setContacts(int index, Contact contact){
        contacts.set(index,new Contact(contact));
    }
    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }
    public void removeContact(String contactName){
        if(contacts.isEmpty())
        {
            throw new IllegalStateException("you cannot remove contact from empty list");
        }

        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equals(contactName)){
                contacts.remove(i);
            }
        }
    }
    @Override
    public String toString(){
        String temp = "";
        for(int i= 0;i < contacts.size(); i++)
        {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }

        return temp;
    }
    
}
