package ahmedmaher.designpattern.structural;

public class Decorator {

    public static void main(String[] args) {
        IBeverage IBeverage1 = new Expresso();
        IBeverage1 = new Milk(IBeverage1);
        IBeverage1 = new Whip(IBeverage1);

        System.out.println("Order: " + IBeverage1.getDescription());
        System.out.println("Cost: $" + IBeverage1.getCost());

        IBeverage IBeverage2 = new Decaf();
        IBeverage2 = new Milk(IBeverage2);

        System.out.println("\nOrder: " + IBeverage2.getDescription());
        System.out.println("Cost: $" + IBeverage2.getCost());

    }
}

// Component
interface IBeverage {
    String getDescription();
    double getCost();
}


// Concrete Components
class Expresso implements IBeverage {
    private final String description = "Expresso";
    private final double cost = 2.00;


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

class Decaf implements IBeverage {
    private final String description = "Decaf";
    private final double cost = 3.00;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

// Decorator
abstract class CondimentDecorator implements IBeverage {
    protected IBeverage IBeverage;

    public CondimentDecorator(IBeverage IBeverage) {
        this.IBeverage = IBeverage;
    }
}

// Concrete Decorators

class Milk extends CondimentDecorator {
    private final String description = "Milk";
    private final double cost = 1.5;
    public Milk(IBeverage IBeverage) {
        super(IBeverage);
    }
    @Override
    public String getDescription() {
        return this.IBeverage.getDescription() + " , " + description;
    }

    @Override
    public double getCost() {
        return this.IBeverage.getCost() + cost;
    }
}

class Whip extends CondimentDecorator {

    private final String description = "Whip";
    private final double cost = 2.5;
    public Whip(IBeverage IBeverage) {
        super(IBeverage);
    }
    @Override
    public String getDescription() {
        return this.IBeverage.getDescription() + " , " + description;
    }

    @Override
    public double getCost() {
        return this.IBeverage.getCost() + cost;
    }
}

















