package service;
import java.util.*;

public class ShippingService {
    private Map<Integer, String> deliveries = new HashMap<>();

    public void ship(int orderId, String item) {
        deliveries.put(orderId, "Created");
        System.out.println("Shipping created: " + item);
    }

    public void cancel(int orderId) {
        deliveries.put(orderId, "Cancelled");
        System.out.println("Shipping cancelled");
    }

    public String getStatus(int orderId) {
        return deliveries.getOrDefault(orderId, "Not found");
    }
}
