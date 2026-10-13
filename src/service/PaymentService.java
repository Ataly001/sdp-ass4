package service;
public class PaymentService {
    public boolean pay(boolean approved) {
        if (approved) {
            System.out.println("Payment successful");
            return true;
        }
        System.out.println("Payment declined");
        return false;
    }
}
