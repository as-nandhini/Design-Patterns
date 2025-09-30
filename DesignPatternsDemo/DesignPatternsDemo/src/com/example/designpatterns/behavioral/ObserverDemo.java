package com.example.designpatterns.behavioral;
import java.util.ArrayList;
import java.util.List;
interface WeatherSubject {
    void addObserver(WeatherObserver o);
    void removeObserver(WeatherObserver o);
    void notifyObservers();
}
class WeatherStation implements WeatherSubject {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("\n[WeatherStation] temperature changed to " + temp + "°C");
        notifyObservers();
    }
    @Override
    public void addObserver(WeatherObserver o) { observers.add(o); }
    @Override
    public void removeObserver(WeatherObserver o) { observers.remove(o); }
    @Override
    public void notifyObservers() {
        for (WeatherObserver o : observers) o.update(temperature);
    }
}
interface WeatherObserver {
    void update(int temp);
}
class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(int temp) {
        System.out.println("Phone Display: Temperature updated to " + temp + "°C");
    }
}
class LaptopDisplay implements WeatherObserver {
    @Override
    public void update(int temp) {
        System.out.println("Laptop Display: Temperature updated to " + temp + "°C");
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new LaptopDisplay());
        station.setTemperature(30);
        station.setTemperature(25);
    }
}