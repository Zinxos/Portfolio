package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String dateOfBirth;
    private String phoneNumber;

    public Contact( String name, String phoneNumber, String dateOfBirth) throws ParseException {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if(phoneNumber == null || phoneNumber.isBlank())
        {
            throw new IllegalArgumentException("phone number cannot be null or blank");
        }
        if(phoneNumber.length() < 5)
        {
            throw new IllegalArgumentException("phone number cannot be less than 5 character");
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.age = toAge(dateOfBirth);

    }
    public Contact(Contact source){
        this.name = source.name;
        this.age = source.age;
        this.dateOfBirth = source.dateOfBirth;
        this.phoneNumber = source.phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null|| name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age < 0)
        {
            throw new IllegalArgumentException("age cannot be less than 0");
        }
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        this.dateOfBirth = dateOfBirth;
        setAge(toAge(dateOfBirth));
    }

    public String getPhoneNumber() {
        if(phoneNumber == null || phoneNumber.isBlank())
        {
            throw new IllegalArgumentException("phone number cannot be null or blank");
        }
        if(phoneNumber.length() < 5)
        {
            throw new IllegalArgumentException("phone number cannot be less than 5 character");
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int toAge(String dateOfBirth) throws ParseException {
        SimpleDateFormat dataCounter = new SimpleDateFormat("MM/dd/yyyy");
        dataCounter.setLenient(false);
        long diff = new Date().getTime() - dataCounter.parse(dateOfBirth).getTime();
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)/365);
    }
    @Override
    public String toString(){
        return "Name: " + this.name + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "Birth Date: " + this.dateOfBirth + "\n" +
                "Age: " + this.age + " year old\n";
    }
}
