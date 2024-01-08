package ahmedmaher.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Command {
//    Command: Interface that declares an abstract method for executing a command.
//    ConcreteCommand: Class that implements the Command interface and encapsulates a specific action with its parameters.
//    Invoker: Class that holds and executes commands.
//    Receiver: Class that performs the action associated with a command.
//    Client: Creates ConcreteCommand objects and associates them with the appropriate receivers.

    public static void main(String[] args) {
        Stock stock = new Stock("ABC" , 10);

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();

        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}

// Command
interface IOrder {
    void execute();
}

// Concrete Commands
class BuyStock implements IOrder {
    // receiver
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

class SellStock implements IOrder {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

// Receiver
class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

// Invoker
class Broker {
    // Command
    private List<IOrder> orders;

    public Broker() {
        this.orders = new ArrayList<>();
    }

    public void takeOrder(IOrder order){
        orders.add(order);
    }
    public void placeOrders() {
        for (IOrder order: orders) {
            order.execute();
        }
        orders.clear();
    }
}
