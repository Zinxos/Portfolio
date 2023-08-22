package models;

public class Item {

    private String name;
    private double price;
    public Item(String name, double price){
        if(name.isBlank()||name== null){
            throw new IllegalArgumentException("name of item cannot be null or blank");
        }
        if(price <= 0){
            throw new IllegalArgumentException("item price can bo less or equal 0");
        }
        this.name = name;
        this.price = price;
    }
    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()||name== null){
            throw new IllegalArgumentException("name of item cannot be null or blank");
        }
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(!(obj instanceof Item)){
            return false;
        }
        Item item = (Item)obj;
            return this.name.equals(((Item) obj).name) && this.price == ((Item) obj).price ;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("item price can bo less or equal 0");
        }
        this.price = price;
    }
    @Override
    public String toString(){
                return "name of item: " + this.name + "\nprice of item: " + this.price+"\n";
    }
}
