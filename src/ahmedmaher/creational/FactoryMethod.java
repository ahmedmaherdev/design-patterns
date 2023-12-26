package ahmedmaher.creational;

public class FactoryMethod {
    public static void main(String[] args) {
        Logistics seaLogistics = new SeaLogistics();
        Logistics roadLogistics = new RoadLogistics();

        seaLogistics.planDelivery();
        roadLogistics.planDelivery();
    }
}


abstract class Logistics {
        public abstract Transport createTransport();
        public void planDelivery() {
            Transport t = this.createTransport();
            t.deliver();
        }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

interface Transport {
    void deliver();
}

class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Truck deliver");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Ship deliver");
    }
}