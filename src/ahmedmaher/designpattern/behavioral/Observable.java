package ahmedmaher.designpattern.behavioral;

import java.util.ArrayList;

public class Observable {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.add(currentConditionsDisplay);
        weatherData.add(statisticsDisplay);
        weatherData.add(forecastDisplay);

        weatherData.setTemperature(10);
        weatherData.setTemperature(20);
        weatherData.setTemperature(30);

    }
}

// Observable
interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers();
}

// Observer
interface IObserver {
    void update(int temperature);
}

// Concrete Observable
class WeatherData implements IObservable {
    private ArrayList<IObserver> observers;
    private int temperature;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observers
class CurrentConditionsDisplay implements IObserver {

    private int temperature;
    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("CurrentConditionsDisplay -> Current Condition: " + temperature + "F degrees.");
    }
}

class StatisticsDisplay  implements IObserver {
    private int temperature;
    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("StatisticsDisplay -> Current Condition: " + temperature + "F degrees.");
    }
}

class ForecastDisplay  implements IObserver {
    private int temperature;
    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("ForecastDisplay -> Current Condition: " + temperature + "F degrees.");
    }
}

















