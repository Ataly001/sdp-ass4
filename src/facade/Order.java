package facade;
public class Order {
    private int id;
    private String item;
    private String customer;
    private int price;
    private boolean cancelled;

    public Order(int id, String item, String customer, int price) {
        this.id = id;
        this.item = item;
        this.customer = customer;
        this.price = price;
        this.cancelled = false;
    }
    public int getId() {
        return id;
    }
    public String getItem() {
        return item;
    }
    public String getCustomer() {
        return customer;
    }
    public int getPrice() {
        return price;
    }
    public boolean isCancelled() {
        return cancelled;
    }
    public void cancel() {
        cancelled = true;
    }
}
