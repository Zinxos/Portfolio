package models;

public class Movie {
    private String name;
    private String format;
    private int rating;
    private double rentPrice;
    private double sellPrice;
    private boolean isAvailable;


    public Movie (String name, String format, int rating){
        if(name == null||format==null||format.isBlank()||name.isBlank())
        {
            throw new IllegalStateException("name and format cannot be null or blank");
        }
        if(!format.equals("DVD")&&!format.equals("BlueRay"))
        {
            throw new IllegalStateException("we only accept movies in DVD or BlueRay format");
        }
        if(rating > 10||rating<1){
            throw new IllegalStateException("rating must be in 1-10");
        }
        this.format = format;
        this.name = name;
        this.rating = rating;
        this.rentPrice = format == "DVD"? 0.99 : 2.25;
        this.sellPrice = format == "DVD"? 1.99 : 4.25;
        this.isAvailable = true;
    }

    public Movie (Movie sorce){
        this.rating = sorce.rating;
        this.name = sorce.name;
        this.format = sorce.format;
        this.sellPrice = sorce.sellPrice;
        this.rentPrice = sorce.rentPrice;
        this.isAvailable = sorce.isAvailable;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    private void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    private void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name==null||name.isBlank()){
            throw new IllegalStateException("Movie title cannot be null or blank");
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if(!format.equals("DVD")&&!format.equals("BlueRay"))
        {
            throw new IllegalStateException("we only accept movies in DVD or BlueRay format");
        }
        if(format==null||format.isBlank()){
            throw new IllegalStateException("format cannot be null or blank");
        }
        this.format = format;
        setRentPrice( format == "DVD"? 0.99 : 2.25);
        setSellPrice( format == "DVD"? 1.99 : 4.25);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating > 10||rating<1){
            throw new IllegalStateException("rating must be in 1-10");
        }
        this.rating = rating;
    }

    @Override
    public String toString() {
        String howToRead = "Movie title is: " + this.name + "\n" + "format: " + this.format + "\n" +
                "rating is: " + this.rating + "/10" + "\n" + "its reting cost is: " + rentPrice + "$ per day \n" + "sell cost it: " + sellPrice + "$\n" +"this video is: ";
        if (this.isAvailable == true)
        {
            howToRead += "available";
        }else{
            howToRead += "unavailable";
        }
    return howToRead;
    }
    
}
