package facade;
public class Order {
    public int id;
    public String item;
    public String customer;
    public int price;
    public boolean cancelled;

    public Order(int id, String item, String customer, int price) {
        this.id = id;
        this.item = item;
        this.customer = customer;
        this.price = price;
        this.cancelled = false;
    }
}
