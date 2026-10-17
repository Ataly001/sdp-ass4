package service;
import java.util.*;

public class ShippingService {
    private Map<Integer, String> deliveries = new HashMap<>();
    public boolean ship(int orderId, String item) {
        if (item.equals("BrokenItem")) {
            System.out.println("Shipping failed");
            return false;
        }
        deliveries.put(orderId, "Created");
        System.out.println("Shipping created: " + item);
        return true;
    }
    public void cancel(int orderId) {
        deliveries.put(orderId, "Cancelled");
        System.out.println("Shipping cancelled");
    }
    public String getStatus(int orderId) {
        return deliveries.getOrDefault(orderId, "Not found");
    }
}
