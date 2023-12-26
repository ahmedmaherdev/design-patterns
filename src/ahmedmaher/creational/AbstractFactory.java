package ahmedmaher.creational;

public class AbstractFactory {
    public static void main(String[] args) {
        ModernFurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        VictorianFurnitureFactory victorianFurnitureFactory = new VictorianFurnitureFactory();

        Chair modernChair =  modernFurnitureFactory.createChair();
        Chair victorianChair =  victorianFurnitureFactory.createChair();

        modernChair.sitOn();
        victorianChair.sitOn();



    }
}


interface FurnitureFactory {
    Chair createChair();
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}

interface Chair {
    boolean hasLegs();
    void sitOn();
}

class ModernChair implements Chair {
    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("You can sit on this modern chair.");
    }
}

class VictorianChair implements Chair {
    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("You can sit on this victorian chair.");
    }
}


