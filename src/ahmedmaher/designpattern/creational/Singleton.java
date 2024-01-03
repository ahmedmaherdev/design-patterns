package ahmedmaher.designpattern.creational;

public class Singleton {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.logMessage("First message logged.");
        logger2.logMessage("Second message logged.");
        
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton).");
        } else {
            System.out.println("Both logger instances are different.");
        }
    }
}

// Singleton Class
class Logger {
    private static Logger logger;

    private Logger() {}

    public static Logger getInstance() {
        if(logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void logMessage(String msg) {
        System.out.println(msg);
    }
}