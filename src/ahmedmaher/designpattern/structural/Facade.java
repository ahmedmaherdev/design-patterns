package ahmedmaher.designpattern.structural;

public class Facade {
    public static void main(String[] args) {
        HomeThreaderFacade homeThreaderFacade = new HomeThreaderFacade(
                new DVDPlayer(),
                new Amplifier(),
                new Speakers(),
                new Projector()
        );

        homeThreaderFacade.watchMovie("Inception");
        homeThreaderFacade.endMovie();
    }

}


// Facade
class HomeThreaderFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Speakers speakers;
    private Projector projector;

    public HomeThreaderFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Speakers speakers, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.speakers = speakers;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        dvdPlayer.turnOn();
        amplifier.turnOn();
        speakers.turnOn();
        projector.turnOn();
        projector.setInput(dvdPlayer);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater system...");
        dvdPlayer.turnOff();
        amplifier.turnOff();
        speakers.turnOff();
        projector.turnOff();
    }
}

// Subsystems Classes
class DVDPlayer {
    public void turnOn() {
        System.out.println("DVD Player is ON.");
    }

    public void turnOff() {
        System.out.println("DVD Player is OFF.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class Amplifier  {
    public void turnOn() {
        System.out.println("Amplifier is ON.");
    }

    public void turnOff() {
        System.out.println("Amplifier is OFF.");
    }
}

class Speakers   {
    public void turnOn() {
        System.out.println("Speakers is ON.");
    }

    public void turnOff() {
        System.out.println("Speakers is OFF.");
    }
}

class Projector  {
    public void turnOn() {
        System.out.println("Projector is ON.");
    }

    public void turnOff() {
        System.out.println("Projector is OFF.");
    }

    public void setInput(DVDPlayer dvdPlayer) {
        System.out.println("Setting projector input to DVD Player");
    }
}
