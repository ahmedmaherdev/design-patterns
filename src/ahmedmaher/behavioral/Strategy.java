package ahmedmaher.behavioral;

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9012-3456", "123", "12/24"));
        shoppingCart.checkout(100.0);

        shoppingCart.setPaymentStrategy(new PaypalPaymentStrategy("user@example.com", "password123"));
        shoppingCart.checkout(50.0);
    }
}

// Strategy
interface IPaymentStrategy {
    void pay(double amount);
}

// Concrete Strategys
class PaypalPaymentStrategy implements IPaymentStrategy {
    private String email;
    private String password;

    public PaypalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class CreditCardPaymentStrategy implements IPaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPaymentStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}


// Context
class ShoppingCart {
    private IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}
