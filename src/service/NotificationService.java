package service;
import java.util.*;

public class NotificationService {

    private List<String> messages = new ArrayList<>();

    public void send(String customer, String message) {
        String text = customer + ": " + message;
        messages.add(text);
        System.out.println("Notification: " + text);
    }

    public int getCount() {
        return messages.size();
    }
}
