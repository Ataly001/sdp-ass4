import facade.OrderFacade;
public class Main {
    public static void main(String[] args) {
        OrderFacade order = new OrderFacade();

        System.out.println("TEST 1: Successful order");
        int id = order.placeOrder("Headphones", "Ataly", true);
        order.showStock("Headphones");
        order.showBalance();

        System.out.println();

        System.out.println("TEST 2: Failed payment");
        order.placeOrder("Keyboard", "Ataly", false);
        order.showStock("Keyboard");

        System.out.println();

        System.out.println("TEST 3: Out of stock");
        order.placeOrder("Mouse", "Ataly", true);

        System.out.println();

        System.out.println("TEST 4: Cancel order");
        order.cancelOrder(id);
        order.showStock("Headphones");
        order.showBalance();
        order.showShipping(id);
        order.showNotifications();

        System.out.println();

        System.out.println("TEST 5: Shipping failure");
        order.placeOrder("BrokenItem", "Ataly", true);
        order.showStock("BrokenItem");
        order.showBalance();

        System.out.println();

        System.out.println("TEST 6: Cancel again");
        order.cancelOrder(id);
        order.showBalance();

        System.out.println();

        System.out.println("TEST 7: Multiple orders");
        order.placeOrder("Headphones", "Ali", true);
        order.placeOrder("Keyboard", "Dana", true);
        order.showBalance();
    }
}
