package ahmedmaher.designpattern.creational;

public class Singleton {

    public static void main(String[] args) {
        NetworkCard networkCard1 = NetworkCard.create();
        NetworkCard networkCard2 = NetworkCard.create();
        NetworkCard networkCard3 = NetworkCard.create();

        networkCard1.display();
        networkCard2.display();
        networkCard3.display();
    }
}


class NetworkCard {
    private static NetworkCard networkCard;
    private NetworkCard() {
        System.out.println("Instance Created...");
    }
    public static NetworkCard create() {
        if(NetworkCard.networkCard == null)  NetworkCard.networkCard = new NetworkCard();
        return NetworkCard.networkCard;
    }

    public void display() {
        System.out.println("Hello!");
    }
}
