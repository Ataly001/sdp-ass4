package facade;
import service.*;
import java.util.*;

public class OrderFacade {
    private InventoryService inventory = new InventoryService();
    private PaymentService payment = new PaymentService();
    private ShippingService shipping = new ShippingService();
    private NotificationService notification = new NotificationService();

    private Map<Integer, Order> orders = new HashMap<>();
    private int nextId = 1;

    public int placeOrder(String item, String customer, boolean approved) {
        System.out.println("New order: " + item);
        if (!inventory.reserve(item)) {
            System.out.println("Order failed");
            return -1;
        }
        int price = inventory.getPrice(item);
        if (!payment.pay(price, approved)) {
            inventory.release(item);
            System.out.println("Order failed");
            return -1;
        }
        int id = nextId;
        if (!shipping.ship(id, item)) {
            payment.refund(price);
            inventory.release(item);
            System.out.println("Order failed");
            return -1;
        }
        Order order = new Order(id, item, customer, price);
        orders.put(id, order);
        nextId++;

        notification.send(customer, "Order " + id + " completed");

        System.out.println("Order ID: " + id);
        return id;
    }

    public boolean cancelOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order == null || order.isCancelled()) {
            System.out.println("Cannot cancel order");
            return false;
        }

        shipping.cancel(orderId);
        payment.refund(order.getPrice());
        inventory.release(order.getItem());
        order.cancel();
        notification.send(order.getCustomer(),
                "Order " + orderId + " cancelled");

        System.out.println("Order cancelled");
        return true;
    }

    public void showStock(String item) {
        System.out.println(item + " stock: " + inventory.getStock(item));
    }

    public void showBalance() {
        System.out.println("Balance: $" + payment.getBalance());
    }

    public void showShipping(int orderId) {
        System.out.println("Shipping: " + shipping.getStatus(orderId));
    }

    public void showNotifications() {
        System.out.println("Notifications: " + notification.getCount());
    }
}
