import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp,o.timestamp);
    }

    public enum Type {WITHDRAW, DEPOSIT};

    private Type type;

    private long timestamp;

    private String id;

    private double amount;

    public Transaction (Type type, long timestamp, String id, double amount){
        if(id == null || id.isBlank())
        {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        if(amount <= 0)
        {
            throw new IllegalArgumentException("amount cannot be less or equal 0");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source){
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }

    public Transaction.Type getType() {
        return type;
    }

    public void setType(Transaction.Type type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank())
        {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if(amount <= 0)
        {
            throw new IllegalArgumentException("amount cannot be less or equal 0");
        }
        this.amount = amount;
    }
    public String returnDate(){
       Date date = new Date(this.timestamp * 1000);
       return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Transaction)){
            return false;
        }
        Transaction transaction = (Transaction) o;
        return this.timestamp == transaction.timestamp && id== transaction.id && type==transaction.type && transaction.amount == amount;
    }

    @Override
    public int hashCode(){
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public String toString() {
        return (type) + "    " +
                "\t" + returnDate() + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }
}
