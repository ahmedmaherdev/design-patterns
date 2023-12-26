package ahmedmaher.structural;

public class Decorator {

    public static void main(String[] args) {
        Beverage beverage1 = new Expresso();
        beverage1 = new Milk(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println("Order: " + beverage1.getDescription());
        System.out.println("Cost: $" + beverage1.getCost());

        Beverage beverage2 = new Decaf();
        beverage2 = new Milk(beverage2);

        System.out.println("\nOrder: " + beverage2.getDescription());
        System.out.println("Cost: $" + beverage2.getCost());

    }
}

// Component
interface Beverage {
    String getDescription();
    double getCost();
}


// Concrete Components
class Expresso implements Beverage {
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

class Decaf implements Beverage {
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
abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// Concrete Decorators

class Milk extends CondimentDecorator {
    private final String description = "Milk";
    private final double cost = 1.5;
    public Milk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " , " + description;
    }

    @Override
    public double getCost() {
        return this.beverage.getCost() + cost;
    }
}

class Whip extends CondimentDecorator {

    private final String description = "Whip";
    private final double cost = 2.5;
    public Whip(Beverage beverage) {
        super(beverage);
    }
    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " , " + description;
    }

    @Override
    public double getCost() {
        return this.beverage.getCost() + cost;
    }
}

















