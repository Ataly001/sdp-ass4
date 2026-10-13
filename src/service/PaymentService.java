package service;
public class PaymentService {
    private int balance = 0;
    public boolean pay(int amount, boolean approved) {
        if (!approved) {
            System.out.println("Payment declined");
            return false;
        }
        balance += amount;
        System.out.println("Payment successful: $" + amount);
        return true;
    }
    public void refund(int amount) {
        balance -= amount;
        System.out.println("Refund completed: $" + amount);
    }
    public int getBalance() {
        return balance;
    }
}
