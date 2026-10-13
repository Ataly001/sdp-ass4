package service;
import java.util.*;
public class InventoryService {

    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Integer> prices = new HashMap<>();

    public InventoryService() {
        stock.put("Headphones", 2);
        stock.put("Keyboard", 1);
        prices.put("Headphones", 100);
        prices.put("Keyboard", 150);
    }

    public boolean reserve(String item) {
        int count = stock.getOrDefault(item, 0);
        if (count == 0) {
            System.out.println("Out of stock: " + item);
            return false;
        }
        stock.put(item, count - 1);
        System.out.println("Reserved: " + item);
        return true;
    }
    public void release(String item) {
        int count = stock.getOrDefault(item, 0);
        stock.put(item, count + 1);
        System.out.println("Returned to stock: " + item);
    }
    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }
    public int getPrice(String item) {
        return prices.getOrDefault(item, 0);
    }
}
