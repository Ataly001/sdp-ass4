package service;
public class InventoryService {
    private int stock = 5;
    public boolean reserve() {
        if (stock > 0) {
            stock--;
            System.out.println("Item reserved");
            return true;
        }
        System.out.println("Out of stock");
        return false;
    }
    public void release() {
        stock++;
        System.out.println("Item returned to stock");
    }
    public int getStock() {
        return stock;
    }
}
