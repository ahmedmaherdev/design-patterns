package ahmedmaher.designpattern.creational;

public class FactoryMethod {
    public static void main(String[] args) {
        EmailNotificationFactory emailNotificationFactory = new EmailNotificationFactory();
        Notification emailNotification = emailNotificationFactory.createNotification();
        emailNotification.sendNotification("Welcome to our platform via Email");

        SMSNotificationFactory smsNotificationFactory = new SMSNotificationFactory();
        Notification smsNotification = smsNotificationFactory.createNotification();
        smsNotification.sendNotification("Welcome to our platform via SMS");

    }
}


// Product
abstract class Notification {
    abstract void sendNotification(String message);
}

// Concrete Products
class EmailNotification extends Notification {

    @Override
    void sendNotification(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}

class SMSNotification extends Notification {

    @Override
    void sendNotification(String message) {
        System.out.println("Sending SMS Notification: " + message);
    }
}

// Creator
abstract class NotificationFactory {
    abstract Notification createNotification();
}

// Concrete Creators
class EmailNotificationFactory extends NotificationFactory {

    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {

    @Override
    Notification createNotification() {
        return new SMSNotification();
    }
}











